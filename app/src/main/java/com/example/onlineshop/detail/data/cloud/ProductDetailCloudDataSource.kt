package com.example.onlineshop.detail.data.cloud

import com.example.core.CloudDataSource
import com.example.core.domain.HandleError
import com.example.onlineshop.detail.data.ProductDetailData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @author Vitaly.N on 12.03.2023.
 */
interface ProductDetailCloudDataSource {

    suspend fun fetchProductDetail(): ProductDetailData

    class Base(
        private val productDetailService: ProductDetailService,
        handleError: HandleError,
        private val mapper: ProductDetailDtoToDataMapper,
        private val gson: Gson,
    ) : CloudDataSource.Abstract(handleError), ProductDetailCloudDataSource {

        override suspend fun fetchProductDetail() = handle {
            val product: ProductDetailDTO = gson.fromJson(
                productDetailService.fetchProductDetail().string(),
                object : TypeToken<ProductDetailDTO>() {}.type
            )
            product.map(mapper)
        }
    }
}