package com.example.onlineshop.detail.domain

import com.example.onlineshop.detail.data.ProductDetailRepository

/**
 * @author Vitaly.N on 12.03.2023.
 */
interface ProductDetailIteractor {
    suspend fun fetchProductDetail(): ProductDetailResult

    class Base(
        private val repository: ProductDetailRepository,
        private val domainToUiMapper: ProductDetailDomainToUiMapper
    ) : ProductDetailIteractor {
        override suspend fun fetchProductDetail(): ProductDetailResult {
            return ProductDetailResult.Success(
                repository.fetchProductDetail().map(domainToUiMapper)
            )
        }
    }
}