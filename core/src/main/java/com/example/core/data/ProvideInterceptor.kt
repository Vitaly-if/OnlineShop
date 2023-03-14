package com.example.core.data

import okhttp3.logging.HttpLoggingInterceptor

/**
 * @author Vitaly.N on 09.03.2023.
 */
interface ProvideInterceptor {

    fun interceptor(): HttpLoggingInterceptor

    abstract class Abstract(
        private val loggingLevel: HttpLoggingInterceptor.Level
    ) : ProvideInterceptor {

        override fun interceptor() = HttpLoggingInterceptor().apply {
            level = loggingLevel
        }
    }

    class Debug : Abstract(HttpLoggingInterceptor.Level.BODY)

    class Release : Abstract(HttpLoggingInterceptor.Level.NONE)
}