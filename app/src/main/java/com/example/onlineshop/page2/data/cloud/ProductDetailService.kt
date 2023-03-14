package com.example.onlineshop.page2.data.cloud

import okhttp3.ResponseBody
import retrofit2.http.GET

/**
 * @author Vitaly.N on 12.03.2023.
 */
interface ProductDetailService {
    @GET("v3/f7f99d04-4971-45d5-92e0-70333383c239")
    suspend fun fetchProductDetail(): ResponseBody
}