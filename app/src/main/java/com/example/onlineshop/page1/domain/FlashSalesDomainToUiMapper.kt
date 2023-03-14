package com.example.onlineshop.page1.domain

import com.example.onlineshop.page1.ui.FlashSaleUi

/**
 * @author Vitaly.N on 11.03.2023.
 */
class FlashSalesDomainToUiMapper(
    private val mapper: FlashSaleDomainToUiMapper
):
    com.example.core.presenter.Mapper<List<FlashSaleUi>, List<FlashSaleDomain>> {
    override fun map(source: List<FlashSaleDomain>): List<FlashSaleUi> {
        val list = mutableListOf<FlashSaleUi>()
        source.forEachIndexed { index, flashSaleDomain ->
            list.add(flashSaleDomain.map(mapper, index.toString()))
        }
        return list
    }
}