package com.example.onlineshop.page1.domain

import com.example.onlineshop.page1.FlashSaleNavigation
import com.example.onlineshop.page1.data.FlashSaleRepository
import com.example.onlineshop.page1.data.LatestRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

/**
 * @author Vitaly.N on 09.03.2023.
 */
interface ProductIteractor {
    suspend fun fetchProduct(): ProductResult
    fun fetchFlashSaleNavigatator(): FlashSaleNavigation.Observe
    class Base(
        private val latestRepository: LatestRepository,
        private val flashSaleRepository: FlashSaleRepository,
        private val latestesDomainToUiMapper: LatestesDomainToUiMapper,
        private val flashSalesDomainToUiMapper: FlashSalesDomainToUiMapper,
        private val flashSaleNavigation: FlashSaleNavigation.Base,
    ) : ProductIteractor {
        override fun fetchFlashSaleNavigatator(): FlashSaleNavigation.Observe {
            return flashSaleNavigation
        }

        override suspend fun fetchProduct(): ProductResult = coroutineScope {

            val a = async { latestRepository.fetchLatest() }
            val b = async { flashSaleRepository.fetchFlashSale() }

            val latestesDomain = a.await()
            val flashSaleDomain = b.await()

            return@coroutineScope if ((latestesDomain.isNotEmpty()) && (flashSaleDomain.isNotEmpty()))
                ProductResult.Success(latestList = latestesDomainToUiMapper.map(latestesDomain),
                    flashSaleList = flashSalesDomainToUiMapper.map(flashSaleDomain))
            else ProductResult.Failure("error")

        }

    }

}