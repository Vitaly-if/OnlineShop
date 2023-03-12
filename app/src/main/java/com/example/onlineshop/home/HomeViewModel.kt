package com.example.onlineshop.home

import androidx.lifecycle.*
import com.example.onlineshop.home.domain.ProductIteractor
import com.example.onlineshop.home.domain.ProductResult
import com.example.onlineshop.home.ui.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val iteractor: ProductIteractor) : ViewModel(),
    ObserveHome {

    private val communications = HomeCommunications.Base(
        LatestListCommunication.Base(),
        FlashSaleListCommunication.Base()
    )

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