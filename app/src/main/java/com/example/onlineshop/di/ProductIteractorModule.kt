package com.example.onlineshop.di

import com.example.onlineshop.home.FlashSaleNavigation
import com.example.onlineshop.home.data.FlashSaleRepository
import com.example.onlineshop.home.data.LatestRepository
import com.example.onlineshop.home.domain.*
import dagger.Module
import dagger.Provides

/**
 * @author Vitaly.N on 09.03.2023.
 */
@Module
class ProductIteractorModule {

    @Provides
    fun provideProductIteractor(
        latestRepository: LatestRepository,
        flashSaleRepository: FlashSaleRepository,
    ): ProductIteractor {
        val flashSaleNavigation = FlashSaleNavigation.Base()
        val latestesDomainToUiMapper = LatestesDomainToUiMapper(LatestDomainToUiMapper())
        val flashSalesDomainToUiMapper = FlashSalesDomainToUiMapper(FlashSaleDomainToUiMapper(flashSaleNavigation))
        return ProductIteractor.Base(latestRepository, flashSaleRepository,latestesDomainToUiMapper,
        flashSalesDomainToUiMapper, flashSaleNavigation)
    }
}