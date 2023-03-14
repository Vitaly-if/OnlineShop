package com.example.onlineshop.page1.data.cloud.flashsale

import com.example.core.data.MakeService
import com.example.core.data.ProvideRetrofitBuilder

/**
 * @author Vitaly.N on 09.03.2023.
 */
interface ProvideFlashSaleService {

    fun flashSaleService(): FlashSaleService

    class Base(
        retrofitBuilder: ProvideRetrofitBuilder,
    ) : MakeService.Abstract(
        retrofitBuilder
    ), ProvideFlashSaleService {

        override fun baseUrl(): String = "https://run.mocky.io/"

        override fun flashSaleService(): FlashSaleService = service(FlashSaleService::class.java)
    }
}