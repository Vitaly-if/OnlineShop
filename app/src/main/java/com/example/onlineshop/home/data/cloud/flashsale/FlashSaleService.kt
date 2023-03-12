package com.example.onlineshop.home.data.cloud.flashsale

import okhttp3.ResponseBody
import retrofit2.http.GET

/**
 * @author Vitaly.N on 09.03.2023.
 */
interface FlashSaleService  {
    @GET("v3/a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun fetchFlashSale(): ResponseBody
}