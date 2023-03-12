package com.example.onlineshop.di

import com.example.onlineshop.signin.data.LoginRepository
import com.example.onlineshop.signin.domain.LoginIteractor
import dagger.Module
import dagger.Provides

/**
 * @author Vitaly.N on 06.03.2023.
 */
@Module
class LoginIteractorModule {

    @Provides
    fun provideLoginIteractor(repository: LoginRepository): LoginIteractor{
        return LoginIteractor.Base(repository)
    }
}