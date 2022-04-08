package com.example.vmediatestapp.presentation

import android.app.Application
import com.example.vmediatestapp.di.DaggerAppComponent

class App:Application() {

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}