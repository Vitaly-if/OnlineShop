package com.example.onlineshop.home.data.cloud.flashsale

import com.example.onlineshop.core.Mapper
import com.example.onlineshop.home.data.FlashSaleData

/**
 * @author Vitaly.N on 09.03.2023.
 */
class FlashSalesDtoToDataMapper(private val mapper: FlashSaleDTO.Mapper<FlashSaleData>) :
    Mapper<List<FlashSaleData>, FlashSalesDTO> {
    override fun map(source: FlashSalesDTO): List<FlashSaleData> {
        val data = mutableListOf<FlashSaleData>()
        source.listFlashSaleDto.forEach { FlashSaleDTO ->
            data.add(FlashSaleDTO.map(mapper))
        }
        return data
    }
}