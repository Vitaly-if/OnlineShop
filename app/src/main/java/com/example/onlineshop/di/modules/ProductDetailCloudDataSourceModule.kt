package com.example.onlineshop.di.modules

import com.example.onlineshop.BuildConfig
import com.example.core.data.ProvideConverterFactory
import com.example.core.data.ProvideInterceptor
import com.example.core.data.ProvideOkHttpClientBuilder
import com.example.core.data.ProvideRetrofitBuilder
import com.example.onlineshop.core.domain.HandleDomainError
import com.example.onlineshop.page2.data.cloud.ProductDetailCloudDataSource
import com.example.onlineshop.page2.data.cloud.ProductDetailDtoToDataMapper
import com.example.onlineshop.page2.data.cloud.ProvideProductDetailService
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