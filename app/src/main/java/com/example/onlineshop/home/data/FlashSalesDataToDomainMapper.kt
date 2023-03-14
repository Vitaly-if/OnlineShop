package com.example.onlineshop.home.data

import com.example.core.presenter.Mapper
import com.example.onlineshop.home.domain.FlashSaleDomain

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