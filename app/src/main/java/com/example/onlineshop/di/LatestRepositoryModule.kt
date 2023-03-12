package com.example.onlineshop.di

import com.example.onlineshop.home.data.cloud.latest.LatestCloudDataSource
import com.example.onlineshop.home.data.LatestDataToDomainMapper
import com.example.onlineshop.home.data.LatestRepository
import com.example.onlineshop.home.data.LatestesDataToDomainMapper
import dagger.Module
import dagger.Provides

/**
 * @author Vitaly.N on 09.03.2023.
 */
@Module
class LatestRepositoryModule {

    @Provides
    fun provideLatestRepository(latestCloudDataSource: LatestCloudDataSource): LatestRepository {
        val latestDataToDomainMapper = LatestDataToDomainMapper()
        val latestesDataToDomainMapper = LatestesDataToDomainMapper(latestDataToDomainMapper)
        return LatestRepository.Base(latestCloudDataSource, latestesDataToDomainMapper)
    }

}

