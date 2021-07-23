package com.solomaticydl.astronomy.datasource

import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.solomaticydl.astronomy.model.AstronomyModel
import com.solomaticydl.astronomy.utils.HttpQueue
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class PictureListDataSource {

    @ExperimentalCoroutinesApi
    suspend fun getData(): List<AstronomyModel> = suspendCancellableCoroutine { continuation ->
        HttpQueue.cancelPendingRequests(TAG)
        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, URL, null,
            { response ->
                try {
                    val moshi = Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                    val jsonAdapter = moshi.adapter(AstronomyModel::class.java)
                    val list = mutableListOf<AstronomyModel>()
                    for (i in 0 until response.length()) {
                        val item = response.getJSONObject(i)
                        val astronomyModel = jsonAdapter.fromJson(item.toString())
                        if (astronomyModel != null) {
                            list.add(astronomyModel)
                        }
                    }
                    continuation.resume(list)
                } catch (e: Exception) {
                    continuation.resumeWithException(e)
                }
            }, {
                continuation.resumeWithException(it)
            })
        HttpQueue.addToRequestQueue(jsonArrayRequest, TAG)
        continuation.invokeOnCancellation {
            jsonArrayRequest.cancel()
        }
    }

    fun cancel() {
        HttpQueue.cancelPendingRequests(TAG)
    }

    companion object {
        private const val TAG = "PictureListDataSource"
        private const val URL =
            "https://raw.githubusercontent.com/cmmobile/NasaDataSet/main/apod.json"
    }
}