package com.example.onlineshop.page1.domain

import com.example.onlineshop.page1.ui.FlashSaleUi
import com.example.onlineshop.page1.ui.LatestUi

/**
 * @author Vitaly.N on 09.03.2023.
 */
sealed class ProductResult {
    interface Mapper<T> {

        fun map(errorMessage: String): T
        fun map(flashSaleList: List<LatestUi>,flashSaleUiList: List<FlashSaleUi>): T
    }

    abstract fun <T> map(mapper: Mapper<T>): T

    data class Success(
        private val latestList: List<LatestUi> = emptyList(),
        private val flashSaleList: List<FlashSaleUi> = emptyList(),
    ) : ProductResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(latestList,flashSaleList)
        fun fetchLatestes(): List<LatestUi> {
            return latestList
        }

        fun fetchFlashSales(): List<FlashSaleUi> {
            return flashSaleList
        }
    }

    data class Failure(private val message: String) : ProductResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(message)
    }
}