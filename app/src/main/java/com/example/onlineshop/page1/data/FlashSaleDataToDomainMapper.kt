package com.example.onlineshop.page1.data

import com.example.onlineshop.page1.domain.FlashSaleDomain

/**
 * @author Vitaly.N on 09.03.2023.
 */
class FlashSaleDataToDomainMapper : FlashSaleData.Mapper<FlashSaleDomain> {
    override fun map(
        category: String,
        name: String,
        price: Float,
        discount: Int,
        imageUrl: String,
    ): FlashSaleDomain {
        return FlashSaleDomain(category, name, price, discount, imageUrl)
    }
}