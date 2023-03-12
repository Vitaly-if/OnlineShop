package com.example.onlineshop.home.data.cloud.latest

import com.google.gson.annotations.SerializedName

/**
 * @author Vitaly.N on 09.03.2023.
 */
data class LatestesDTO(@SerializedName("latest") val listLatestDto: List<LatestDTO>)
