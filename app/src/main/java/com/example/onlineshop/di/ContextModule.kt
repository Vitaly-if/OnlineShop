package com.example.onlineshop.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * @author Vitaly.N on 14.03.2023.
 */
@Module
class ContextModule {
    @Provides
    fun provideContext(application: Application) : Context {
        return application
    }

}