package com.example.onlineshop.page1.data.cloud.flashsale

import com.example.core.CloudDataSource
import com.example.core.domain.HandleError
import com.example.onlineshop.page1.data.FlashSaleData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @author Vitaly.N on 09.03.2023.
 */
interface FlashSaleCloudDataSource {

    suspend fun fetchFlashSale(): List<FlashSaleData>

    class Base(
        private val flashSaleService: FlashSaleService,
        handleError: HandleError,
        private val mapper: FlashSalesDtoToDataMapper,
        private val gson: Gson,
    ) : CloudDataSource.Abstract(handleError), FlashSaleCloudDataSource {

        override suspend fun fetchFlashSale() = handle {
            val list: FlashSalesDTO = gson.fromJson(
                flashSaleService.fetchFlashSale().string(),
                object : TypeToken<FlashSalesDTO>() {}.type
            )
            mapper.map(list)
        }
    }
}