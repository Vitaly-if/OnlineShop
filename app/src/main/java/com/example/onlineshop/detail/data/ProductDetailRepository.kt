package com.example.onlineshop.detail.data

import com.example.onlineshop.detail.data.cloud.ProductDetailCloudDataSource
import com.example.onlineshop.detail.domain.ProductDetailDomain

/**
 * @author Vitaly.N on 12.03.2023.
 */
interface ProductDetailRepository {
    suspend fun fetchProductDetail(): ProductDetailDomain
    class Base(
        private val productDetailCloudDataSource: ProductDetailCloudDataSource,
        private val dataToDomainMapper: ProductDetailDataToDomainMapper,
    ) : ProductDetailRepository {
        override suspend fun fetchProductDetail(): ProductDetailDomain {
            return productDetailCloudDataSource.fetchProductDetail().map(dataToDomainMapper)
        }
    }
}