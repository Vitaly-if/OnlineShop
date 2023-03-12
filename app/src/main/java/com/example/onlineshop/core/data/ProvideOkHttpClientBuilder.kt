package com.example.onlineshop.core.data

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * @author Vitaly.N on 09.03.2023.
 */
interface ProvideOkHttpClientBuilder {

    fun httpClientBuilder(): OkHttpClient.Builder

    abstract class Abstract(
        private val provideInterceptor: ProvideInterceptor,
        private val timeOutSeconds: Long = 60L
    ) : ProvideOkHttpClientBuilder {

        override fun httpClientBuilder() = OkHttpClient.Builder()
            .addInterceptor(provideInterceptor.interceptor())
            .connectTimeout(timeOutSeconds, TimeUnit.SECONDS)
            .readTimeout(timeOutSeconds, TimeUnit.SECONDS)
    }

    class Base(
        provideInterceptor: ProvideInterceptor,
    ) : Abstract(provideInterceptor)
}