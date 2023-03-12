package com.example.onlineshop.di

import com.example.onlineshop.signin.data.cache.LoginCacheDataSource
import com.example.onlineshop.signin.data.cache.LoginDataBase
import dagger.Module
import dagger.Provides

/**
 * @author Vitaly.N on 06.03.2023.
 */
@Module
class LoginCacheDataSourceModule {

    @Provides
    fun loginCacheDataSource(loginDataBase: LoginDataBase): LoginCacheDataSource {
        return LoginCacheDataSource.Base(loginDataBase.loginsDao())
    }
}