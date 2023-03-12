package com.example.onlineshop.home.domain

import com.example.onlineshop.home.FlashSaleNavigation
import com.example.onlineshop.home.ui.FlashSaleUi

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