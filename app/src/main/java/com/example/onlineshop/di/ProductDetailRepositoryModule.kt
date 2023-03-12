package com.example.onlineshop.di

import com.example.onlineshop.detail.data.ProductDetailDataToDomainMapper
import com.example.onlineshop.detail.data.ProductDetailRepository
import com.example.onlineshop.detail.data.cloud.ProductDetailCloudDataSource
import dagger.Module
import dagger.Provides

/**
 * @author Vitaly.N on 11.03.2023.
 */
@Module
class ProductDetailRepositoryModule {

    @Provides
    fun provideProductDetailRepository(provideDetailCloudDataSource: ProductDetailCloudDataSource): ProductDetailRepository {
        val dataToDomainMapper = ProductDetailDataToDomainMapper()
        return ProductDetailRepository.Base(provideDetailCloudDataSource, dataToDomainMapper)
    }

}