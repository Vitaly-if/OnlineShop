package com.example.onlineshop.home.data

import com.example.onlineshop.home.data.cloud.latest.LatestCloudDataSource
import com.example.onlineshop.home.domain.LatestDomain

/**
 * @author Vitaly.N on 09.03.2023.
 */
interface LatestRepository {
    suspend fun fetchLatest(): List<LatestDomain>
    class Base(
        private val latestCloudDataSource: LatestCloudDataSource,
        private val dataToDomainMapper: LatestesDataToDomainMapper,
    ) : LatestRepository {
        override suspend fun fetchLatest(): List<LatestDomain> {
            return dataToDomainMapper.map(latestCloudDataSource.fetchLatest())
        }
    }
}