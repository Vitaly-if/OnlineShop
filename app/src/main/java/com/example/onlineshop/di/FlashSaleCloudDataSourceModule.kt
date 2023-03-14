package com.example.onlineshop.di

import com.example.onlineshop.BuildConfig
import com.example.core.data.ProvideConverterFactory
import com.example.core.data.ProvideInterceptor
import com.example.core.data.ProvideOkHttpClientBuilder
import com.example.core.data.ProvideRetrofitBuilder
import com.example.onlineshop.core.domain.HandleDomainError
import com.example.onlineshop.home.data.cloud.flashsale.FlashSaleCloudDataSource
import com.example.onlineshop.home.data.cloud.flashsale.FlashSaleDtoToDataMapper
import com.example.onlineshop.home.data.cloud.flashsale.FlashSalesDtoToDataMapper
import com.example.onlineshop.home.data.cloud.flashsale.ProvideFlashSaleService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

/**
 * @author Vitaly.N on 09.03.2023.
 */
@Module
class FlashSaleCloudDataSourceModule  {

    @Provides
    fun provideFlashSaleCloudDataSource(): FlashSaleCloudDataSource {
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
        val flashSaleesDtoToDataMapper = FlashSalesDtoToDataMapper(FlashSaleDtoToDataMapper())
        return FlashSaleCloudDataSource.Base(ProvideFlashSaleService.Base(retrofitBuilder)
            .flashSaleService(),
            HandleDomainError(), flashSaleesDtoToDataMapper, gson)
    }

}