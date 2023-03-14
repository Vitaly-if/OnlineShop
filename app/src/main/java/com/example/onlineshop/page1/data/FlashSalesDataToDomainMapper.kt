package com.example.onlineshop.page1.data

import com.example.onlineshop.page1.domain.FlashSaleDomain

/**
 * @author Vitaly.N on 09.03.2023.
 */
class FlashSalesDataToDomainMapper(private val mapper: FlashSaleDataToDomainMapper) :
    com.example.core.presenter.Mapper<List<FlashSaleDomain>, List<FlashSaleData>> {
    override fun map(source: List<FlashSaleData>): List<FlashSaleDomain> {
        val data = mutableListOf<FlashSaleDomain>()
        source.forEach { FlashSaleData ->
            data.add(FlashSaleData.map(mapper))
        }
        return data
    }
}