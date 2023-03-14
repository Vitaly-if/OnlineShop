package com.example.onlineshop.page1.data.cloud.latest

import okhttp3.ResponseBody
import retrofit2.http.GET

/**
 * @author Vitaly.N on 09.03.2023.
 */
interface LatestService {
    @GET("v3/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7/latest")
    suspend fun fetchLatest(): ResponseBody
}