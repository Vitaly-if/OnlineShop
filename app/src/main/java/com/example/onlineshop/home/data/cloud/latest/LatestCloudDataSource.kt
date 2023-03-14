package com.example.onlineshop.home.data.cloud.latest

import com.example.core.CloudDataSource
import com.example.core.domain.HandleError
import com.example.onlineshop.home.data.LatestData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @author Vitaly.N on 09.03.2023.
 */
interface LatestCloudDataSource {

    suspend fun fetchLatest(): List<LatestData>

    class Base(
        private val latestService: LatestService,
        handleError: HandleError,
        private val mapper: LatestesDtoToDataMapper,
        private val gson: Gson,
    ) : CloudDataSource.Abstract(handleError), LatestCloudDataSource {

        override suspend fun fetchLatest() = handle {
            val list: LatestesDTO = gson.fromJson(
                latestService.fetchLatest().string(),
                object : TypeToken<LatestesDTO>() {}.type
            )
            mapper.map(list)
        }
    }
}