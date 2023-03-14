package com.example.onlineshop.page1.data.cloud.flashsale

import com.example.onlineshop.page1.data.FlashSaleData

/**
 * @author Vitaly.N on 09.03.2023.
 */
class FlashSaleDtoToDataMapper : FlashSaleDTO.Mapper<FlashSaleData> {
    override fun map(
        category: String,
        name: String,
        price: Float,
        discount: Int,
        imageUrl: String,
    ): FlashSaleData {
        return FlashSaleData(category, name, price, discount, imageUrl)
    }
}