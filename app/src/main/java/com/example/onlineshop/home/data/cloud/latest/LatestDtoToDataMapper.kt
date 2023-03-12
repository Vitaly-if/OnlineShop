package com.example.onlineshop.home.data.cloud.latest

import com.example.onlineshop.home.data.LatestData

/**
 * @author Vitaly.N on 09.03.2023.
 */
class LatestDtoToDataMapper : LatestDTO.Mapper<LatestData> {
    override fun map(category: String, name: String, price: Float, imageUrl: String): LatestData {
        return LatestData(category, name, price, imageUrl)
    }
}