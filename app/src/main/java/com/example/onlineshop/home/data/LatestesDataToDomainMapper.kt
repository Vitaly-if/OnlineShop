package com.example.onlineshop.home.data

import com.example.onlineshop.core.Mapper
import com.example.onlineshop.home.domain.LatestDomain

/**
 * @author Vitaly.N on 09.03.2023.
 */
class LatestesDataToDomainMapper(private val mapper: LatestDataToDomainMapper) :
    Mapper<List<LatestDomain>, List<LatestData>> {
    override fun map(source: List<LatestData>): List<LatestDomain> {
        val data = mutableListOf<LatestDomain>()
        source.forEach { LatestData ->
            data.add(LatestData.map(mapper))
        }
        return data
    }
}
