package com.example.onlineshop.di

import android.app.Application
import android.content.Context
import com.example.onlineshop.signin.data.cache.LoginCacheModule
import com.example.onlineshop.signin.data.cache.LoginDataBase
import dagger.Module
import dagger.Provides

/**
 * @author Vitaly.N on 05.03.2023.
 */
@Module
class LoginDataBaseModule {

    @Provides
    fun provideDatabaseHelper(context: Context): LoginDataBase {
        return LoginCacheModule.Base(context).provideDataBase()
    }
}


