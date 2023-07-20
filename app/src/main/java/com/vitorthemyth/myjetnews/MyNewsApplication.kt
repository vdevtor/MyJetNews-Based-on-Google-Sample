package com.vitorthemyth.myjetnews

import android.app.Application
import com.vitorthemyth.myjetnews.data.AppContainer
import com.vitorthemyth.myjetnews.data.AppContainerImpl

class MyNewsApplication : Application() {

    companion object {
        const val JETNEWS_APP_URI = "https://developer.android.com/jetnews"
    }

    // AppContainer instance used by the rest of classes to obtain dependencies
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl(this)
    }
}