package com.example.onlineshop.di.modules

import com.example.onlineshop.BuildConfig
import com.example.core.data.ProvideConverterFactory
import com.example.core.data.ProvideInterceptor
import com.example.core.data.ProvideOkHttpClientBuilder
import com.example.core.data.ProvideRetrofitBuilder
import com.example.onlineshop.core.domain.HandleDomainError
import com.example.onlineshop.page1.data.cloud.latest.LatestCloudDataSource
import com.example.onlineshop.page1.data.cloud.latest.LatestDtoToDataMapper
import com.example.onlineshop.page1.data.cloud.latest.LatestesDtoToDataMapper
import com.example.onlineshop.page1.data.cloud.latest.ProvideLatestService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

/**
 * @author Vitaly.N on 09.03.2023.
 */
@Module
class LatestCloudDataSourceModule {

    @Provides
    fun provideLatestCloudDataSource(): LatestCloudDataSource {
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
        val latestesDtotoDataMapper = LatestesDtoToDataMapper(LatestDtoToDataMapper())
        return LatestCloudDataSource.Base(ProvideLatestService.Base(retrofitBuilder)
            .latestService(),
            HandleDomainError(), latestesDtotoDataMapper, gson)
    }

}