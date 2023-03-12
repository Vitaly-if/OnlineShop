package com.example.onlineshop.di

import com.example.onlineshop.signin.data.LoginDataToDomainMapper
import com.example.onlineshop.signin.data.LoginRepository
import com.example.onlineshop.signin.data.cache.LoginCacheDataSource
import dagger.Module
import dagger.Provides

/**
 * @author Vitaly.N on 06.03.2023.
 */
@Module
class LoginRepositoryModule {

    @Provides
    fun provideLoginRepository(loginCacheDataSource: LoginCacheDataSource): LoginRepository {
        val dataToDomainMapper = LoginDataToDomainMapper()
        return LoginRepository.Base(loginCacheDataSource, dataToDomainMapper)
    }
}