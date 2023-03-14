package com.example.onlineshop.di.modules

import com.example.onlineshop.page1.data.cloud.latest.LatestCloudDataSource
import com.example.onlineshop.page1.data.LatestDataToDomainMapper
import com.example.onlineshop.page1.data.LatestRepository
import com.example.onlineshop.page1.data.LatestesDataToDomainMapper
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

