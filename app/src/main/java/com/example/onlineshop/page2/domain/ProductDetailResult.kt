package com.example.onlineshop.page2.domain

import com.example.onlineshop.page2.ui.ProductDetailUi

/**
 * @author Vitaly.N on 12.03.2023.
 */
sealed class ProductDetailResult {
    interface Mapper<T> {
        fun map(errorMessage: String): T
        fun map(productDetailUi: ProductDetailUi): T
    }
    abstract fun <T> map(mapper: Mapper<T>): T

    data class Success(
        private val productDetailUi: ProductDetailUi,
    ) : ProductDetailResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(productDetailUi)

    }
    data class Failure(private val message: String) : ProductDetailResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(message)
    }
}