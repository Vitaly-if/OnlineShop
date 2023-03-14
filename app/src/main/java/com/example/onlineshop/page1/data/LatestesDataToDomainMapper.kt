package com.example.onlineshop.page1.data

import com.example.onlineshop.page1.domain.LatestDomain

/**
 * @author Vitaly.N on 09.03.2023.
 */
class LatestesDataToDomainMapper(private val mapper: LatestDataToDomainMapper) :
    com.example.core.presenter.Mapper<List<LatestDomain>, List<LatestData>> {
    override fun map(source: List<LatestData>): List<LatestDomain> {
        val data = mutableListOf<LatestDomain>()
        source.forEach { LatestData ->
            data.add(LatestData.map(mapper))
        }
        return data
    }
}
