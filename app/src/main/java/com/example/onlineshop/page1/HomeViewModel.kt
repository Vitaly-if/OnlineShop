package com.example.onlineshop.page1

import androidx.lifecycle.*
import com.example.onlineshop.page1.domain.ProductIteractor
import com.example.onlineshop.page1.domain.ProductResult
import com.example.onlineshop.page1.ui.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val iteractor: ProductIteractor,
    private val communications: HomeCommunications,
) : ViewModel(),
    ObserveHome {

    init {
        viewModelScope.launch {
            val productResult: ProductResult.Success =
                iteractor.fetchProduct() as ProductResult.Success
            communications.showLatest(productResult.fetchLatestes())
            communications.showFlashSale(productResult.fetchFlashSales())
        }
    }

    fun observeflashSasleNavigation(owner: LifecycleOwner, observer: Observer<Int>) =
        iteractor.fetchFlashSaleNavigatator().observe(owner, observer)

    override fun observeLatestList(owner: LifecycleOwner, observer: Observer<List<LatestUi>>) {
        communications.observeLatestList(owner, observer)
    }

    override fun observeFlashSaleList(
        owner: LifecycleOwner,
        observer: Observer<List<FlashSaleUi>>,
    ) {
        communications.observeFlashSaleList(owner, observer)
    }

}