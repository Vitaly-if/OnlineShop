package com.example.onlineshop.di

import com.example.onlineshop.detail.data.ProductDetailRepository
import com.example.onlineshop.detail.domain.ProductDetailDomainToUiMapper
import com.example.onlineshop.detail.domain.ProductDetailIteractor
import dagger.Module
import dagger.Provides

/**
 * @author Vitaly.N on 12.03.2023.
 */
@Module
class ProductDetailIteractorModule {

    @Provides
    fun provideIteractorModule(
        productDetailRepository: ProductDetailRepository
    ) : ProductDetailIteractor {
        val productDetailDomainToUiMapper = ProductDetailDomainToUiMapper()
        return ProductDetailIteractor.Base(productDetailRepository, productDetailDomainToUiMapper)
    }
}