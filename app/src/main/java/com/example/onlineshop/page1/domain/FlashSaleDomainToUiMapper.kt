package com.example.onlineshop.page1.domain

import com.example.onlineshop.page1.FlashSaleNavigation
import com.example.onlineshop.page1.ui.FlashSaleUi

/**
 * @author Vitaly.N on 11.03.2023.
 */
class FlashSaleDomainToUiMapper(private val flashSaleNavigation: FlashSaleNavigation.Base): FlashSaleDomain.Mapper<FlashSaleUi> {
    override fun map(
        category: String,
        name: String,
        price: Float,
        discount: Int,
        imageUrl: String,
        id: String
    ): FlashSaleUi {
        return FlashSaleUi(id, category, name, "$ $price", "$discount% off", imageUrl,
            flashSaleNavigation)
    }

}