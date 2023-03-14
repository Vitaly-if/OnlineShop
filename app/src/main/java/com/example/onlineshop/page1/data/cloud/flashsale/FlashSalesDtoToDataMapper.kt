package com.example.onlineshop.page1.data.cloud.flashsale

import com.example.onlineshop.page1.data.FlashSaleData

/**
 * @author Vitaly.N on 09.03.2023.
 */
class FlashSalesDtoToDataMapper(private val mapper: FlashSaleDTO.Mapper<FlashSaleData>) :
    com.example.core.presenter.Mapper<List<FlashSaleData>, FlashSalesDTO> {
    override fun map(source: FlashSalesDTO): List<FlashSaleData> {
        val data = mutableListOf<FlashSaleData>()
        source.listFlashSaleDto.forEach { FlashSaleDTO ->
            data.add(FlashSaleDTO.map(mapper))
        }
        return data
    }
}