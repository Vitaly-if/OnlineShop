package com.example.onlineshop.di

import android.app.Application

/**
 * @author Vitaly.N on 05.03.2023.
 */
open class App: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}
