package com.example.core.data

import okhttp3.logging.HttpLoggingInterceptor

/**
 * @author Vitaly.N on 09.03.2023.
 */
interface MakeService {

    fun <T> service(clasz: Class<T>): T

    abstract class Abstract(
        private val retrofitBuilder: ProvideRetrofitBuilder,
    ) : MakeService {

        private val retrofit by lazy {
            retrofitBuilder.provideRetrofitBuilder()
                .baseUrl(baseUrl())
                .build()
        }

        override fun <T> service(clasz: Class<T>): T = retrofit.create(clasz)

        protected open fun baseUrl(): String = "https://www.google.com"
    }
}