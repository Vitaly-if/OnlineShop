package com.example.onlineshop.di

import com.example.onlineshop.BuildConfig
import com.example.onlineshop.core.data.ProvideConverterFactory
import com.example.onlineshop.core.data.ProvideInterceptor
import com.example.onlineshop.core.data.ProvideOkHttpClientBuilder
import com.example.onlineshop.core.data.ProvideRetrofitBuilder
import com.example.onlineshop.core.domain.HandleDomainError
import com.example.onlineshop.detail.data.cloud.ProductDetailCloudDataSource
import com.example.onlineshop.detail.data.cloud.ProductDetailDtoToDataMapper
import com.example.onlineshop.detail.data.cloud.ProvideProductDetailService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

/**
 * @author Vitaly.N on 12.03.2023.
 */
@Module
class ProductDetailCloudDataSourceModule {

    @Provides
    fun provideProductDetailCloudDataSource(): ProductDetailCloudDataSource {
        val retrofitBuilder = ProvideRetrofitBuilder.Base(
            ProvideConverterFactory.Base(),
            ProvideOkHttpClientBuilder.Base(
                if (BuildConfig.DEBUG)
                    ProvideInterceptor.Debug()
                else
                    ProvideInterceptor.Release()
            )
        )
        val gson = Gson()
        val productDetailDtoToDataMapper = ProductDetailDtoToDataMapper()
        return ProductDetailCloudDataSource.Base(
            ProvideProductDetailService.Base(retrofitBuilder)
                .productDetailService(), HandleDomainError(), productDetailDtoToDataMapper, gson
        )
    }
}