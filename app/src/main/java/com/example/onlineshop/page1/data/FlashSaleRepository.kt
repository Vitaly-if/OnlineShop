package com.example.onlineshop.page1.data

import com.example.onlineshop.page1.data.cloud.flashsale.FlashSaleCloudDataSource
import com.example.onlineshop.page1.domain.FlashSaleDomain

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