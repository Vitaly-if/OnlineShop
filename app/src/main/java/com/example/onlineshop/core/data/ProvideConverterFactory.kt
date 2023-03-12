package com.example.onlineshop.core.data

import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Vitaly.N on 09.03.2023.
 */
interface ProvideConverterFactory {

    fun converterFactory(): Converter.Factory

    class Base : ProvideConverterFactory {

        override fun converterFactory(): Converter.Factory = GsonConverterFactory.create()
    }
}