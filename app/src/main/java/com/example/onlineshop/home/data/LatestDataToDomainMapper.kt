package com.example.onlineshop.home.data

import com.example.onlineshop.home.domain.LatestDomain

/**
 * @author Vitaly.N on 09.03.2023.
 */
class LatestDataToDomainMapper: LatestData.Mapper<LatestDomain> {
    override fun map(category: String, name: String, price: Float, imageUrl: String): LatestDomain {
        return LatestDomain(category, name, price, imageUrl)
    }
}