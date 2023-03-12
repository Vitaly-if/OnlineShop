package com.example.onlineshop.home.domain

import com.example.onlineshop.core.Mapper
import com.example.onlineshop.home.ui.FlashSaleUi

/**
 * @author Vitaly.N on 11.03.2023.
 */
class FlashSalesDomainToUiMapper(
    private val mapper: FlashSaleDomainToUiMapper
):
    Mapper<List<FlashSaleUi>, List<FlashSaleDomain>> {
    override fun map(source: List<FlashSaleDomain>): List<FlashSaleUi> {
        val list = mutableListOf<FlashSaleUi>()
        source.forEachIndexed { index, flashSaleDomain ->
            list.add(flashSaleDomain.map(mapper, index.toString()))
        }
        return list
    }
}