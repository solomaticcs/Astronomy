package com.solomaticydl.astronomy.utils

import android.graphics.Bitmap
import android.util.LruCache
import com.android.volley.toolbox.ImageLoader
import com.solomaticydl.astronomy.extension.toMD5

// refer to this doc:
// https://developer.android.com/topic/performance/graphics/cache-bitmap#memory-cache
class LruBitmapCache(
    maxSize: Int = getDefaultLruCacheSize()
) : LruCache<String, Bitmap>(maxSize), ImageLoader.ImageCache {

    override fun sizeOf(key: String, value: Bitmap): Int {
        // The cache size will be measured in kilobytes rather than
        // number of items.
        return value.byteCount / 1024
    }

    override fun getBitmap(url: String?): Bitmap? {
        if (url != null) {
            return get(url.toMD5())
        }
        return null
    }

    override fun putBitmap(url: String?, bitmap: Bitmap?) {
        if (url != null && bitmap != null) {
            put(url.toMD5(), bitmap)
        }
    }

    companion object {
        fun getDefaultLruCacheSize(): Int {
            // Get max available VM memory, exceeding this amount will throw an
            // OutOfMemory exception. Stored in kilobytes as LruCache takes an
            // int in its constructor.
            val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()

            // Use 1/8th of the available memory for this memory cache.
            return maxMemory / 8
        }
    }
}