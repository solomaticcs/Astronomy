package com.solomaticydl.astronomy

import android.app.Application
import android.content.Context

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        private lateinit var instance: MainApp

        fun getAppContext(): Context = instance.applicationContext
    }
}