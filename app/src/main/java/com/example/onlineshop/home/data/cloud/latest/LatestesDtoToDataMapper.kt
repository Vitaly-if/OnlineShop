package com.example.onlineshop.home.data.cloud.latest

import com.example.onlineshop.core.Mapper
import com.example.onlineshop.home.data.LatestData

/**
 * @author Vitaly.N on 09.03.2023.
 */
class LatestesDtoToDataMapper(private val mapper: LatestDTO.Mapper<LatestData>) :
    Mapper<List<LatestData>, LatestesDTO> {
    override fun map(source: LatestesDTO): List<LatestData> {
        val data = mutableListOf<LatestData>()
        source.listLatestDto.forEach { LatestDTO ->
            data.add(LatestDTO.map(mapper))
        }
        return data
    }
}