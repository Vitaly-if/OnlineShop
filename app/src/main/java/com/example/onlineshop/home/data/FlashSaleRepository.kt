package com.example.onlineshop.home.data

import com.example.onlineshop.home.data.cloud.flashsale.FlashSaleCloudDataSource
import com.example.onlineshop.home.domain.FlashSaleDomain

/**
 * @author Vitaly.N on 09.03.2023.
 */
interface FlashSaleRepository {
    suspend fun fetchFlashSale(): List<FlashSaleDomain>
    class Base(
        private val flashSaleCloudDataSource: FlashSaleCloudDataSource,
        private val dataToDomainMapper: FlashSalesDataToDomainMapper,
    ) : FlashSaleRepository {
        override suspend fun fetchFlashSale(): List<FlashSaleDomain> {
            return dataToDomainMapper.map(flashSaleCloudDataSource.fetchFlashSale())
        }
    }
}