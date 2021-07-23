package com.solomaticydl.astronomy.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class AstronomyModel(
    @Json(name = "description") val description: String = "",
    @Json(name = "copyright") val copyright: String = "",
    @Json(name = "title") val title: String = "",
    @Json(name = "url") val url: String = "",
    @Json(name = "apod_site") val aPodSite: String = "",
    @Json(name = "date") val date: String = "",
    @Json(name = "media_type") val mediaType: String = "",
    @Json(name = "hdurl") val hdUrl: String = ""
) : Parcelable