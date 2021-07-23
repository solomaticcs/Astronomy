package com.solomaticydl.astronomy.utils

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.solomaticydl.astronomy.MainApp

object HttpQueue {

    private const val TAG = "HttpQueue"

    val requestQueue: RequestQueue = Volley.newRequestQueue(MainApp.getAppContext())

    fun <T> addToRequestQueue(request: Request<T>, tag: String = "") {
        request.tag = if (tag.isEmpty()) TAG else tag
        requestQueue.add(request)
    }

    fun cancelPendingRequests(tag: Any) {
        requestQueue.cancelAll(tag)
    }
}