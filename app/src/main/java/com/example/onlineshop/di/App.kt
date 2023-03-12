package com.example.onlineshop.di

import android.app.Application

/**
 * @author Vitaly.N on 05.03.2023.
 */
open class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}
