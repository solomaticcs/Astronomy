package com.solomaticydl.astronomy.utils

import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.NetworkImageView

object ImageLoader {

    private val imageLoader: ImageLoader by lazy {
        ImageLoader(HttpQueue.requestQueue, LruBitmapCache())
    }

    fun loadImageFromUrl(networkImageView: NetworkImageView, url: String) {
        networkImageView.setImageUrl(url, imageLoader)
    }
}