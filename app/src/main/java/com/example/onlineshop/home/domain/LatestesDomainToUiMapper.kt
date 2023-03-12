package com.example.onlineshop.home.domain

import com.example.onlineshop.core.Mapper
import com.example.onlineshop.home.ui.LatestUi

/**
 * @author Vitaly.N on 10.03.2023.
 */
class LatestesDomainToUiMapper(private val mapper: LatestDomainToUiMapper): Mapper<List<LatestUi>, List<LatestDomain>> {
    override fun map(source: List<LatestDomain>): List<LatestUi> {
        val data = mutableListOf<LatestUi>()
        source.forEachIndexed() { index, LatestDomain ->
            data.add(LatestDomain.map(mapper, index.toString()))
        }
        return data
    }
}