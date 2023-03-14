package com.example.onlineshop.di.modules

import com.example.onlineshop.page1.data.*
import com.example.onlineshop.page1.data.cloud.flashsale.FlashSaleCloudDataSource
import dagger.Module
import dagger.Provides

/**
 * @author Vitaly.N on 09.03.2023.
 */
@Module
class FlashSaleRepositoryModule {

    @Provides
    fun provideFlashSaleRepository(latestCloudDataSource: FlashSaleCloudDataSource): FlashSaleRepository {
        val flashSaleDataToDomainMapper = FlashSaleDataToDomainMapper()
        val flashSalesDataToDomainMapper = FlashSalesDataToDomainMapper(flashSaleDataToDomainMapper)
        return FlashSaleRepository.Base(latestCloudDataSource, flashSalesDataToDomainMapper)
    }

}