package com.example.onlineshop.detail.data.cloud

import com.example.onlineshop.core.data.MakeService
import com.example.onlineshop.core.data.ProvideRetrofitBuilder

/**
 * @author Vitaly.N on 12.03.2023.
 */
interface ProvideProductDetailService {

    fun productDetailService(): ProductDetailService

    class Base(
        retrofitBuilder: ProvideRetrofitBuilder,
    ) : MakeService.Abstract(
        retrofitBuilder
    ), ProvideProductDetailService {

        override fun baseUrl(): String = "https://run.mocky.io/"

        override fun productDetailService(): ProductDetailService =
            service(ProductDetailService::class.java)
    }
}