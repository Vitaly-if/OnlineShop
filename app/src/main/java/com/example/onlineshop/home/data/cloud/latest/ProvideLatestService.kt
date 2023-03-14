package com.example.onlineshop.home.data.cloud.latest

import com.example.core.data.MakeService
import com.example.core.data.ProvideRetrofitBuilder

/**
 * @author Vitaly.N on 09.03.2023.
 */
interface ProvideLatestService {

    fun latestService(): LatestService

    class Base(
        retrofitBuilder: ProvideRetrofitBuilder,
    ) : MakeService.Abstract(
        retrofitBuilder
    ), ProvideLatestService {

        override fun baseUrl(): String = "https://run.mocky.io/"

        override fun latestService(): LatestService = service(LatestService::class.java)
    }
}