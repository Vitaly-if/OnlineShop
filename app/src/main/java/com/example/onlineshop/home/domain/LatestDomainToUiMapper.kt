package com.example.onlineshop.home.domain

import com.example.onlineshop.home.ui.LatestUi

/**
 * @author Vitaly.N on 10.03.2023.
 */
class LatestDomainToUiMapper: LatestDomain.Mapper<LatestUi> {
    override fun map(category: String, name: String, price: Float, imageUrl: String, id: String): LatestUi {
        return LatestUi(id = id, category = category, name= name, price = "$ ${price.toString()}", imageUrl = imageUrl )
    }
}