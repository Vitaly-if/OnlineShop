package com.example.onlineshop.page2.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.page2.domain.ProductDetailIteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailProductViewModel @Inject constructor(
    iteractor: ProductDetailIteractor,
    private val detailProductUiMapper: DetailProductUiMapper,
    private val communications: ProductDetailCommunications,
) : ViewModel(),
    ObserveProductDetail {

    init {
        viewModelScope.launch {
            communications.showCard(iteractor.fetchProductDetail().map(detailProductUiMapper))
        }
    }

    override fun observeImageList(owner: LifecycleOwner, observer: Observer<List<String>>) {
        communications.observeImageList(owner, observer)
    }

    override fun observeColorList(owner: LifecycleOwner, observer: Observer<List<String>>) {
        communications.observeColorList(owner, observer)
    }

    override fun observeProductDetailUi(
        owner: LifecycleOwner,
        observer: Observer<ProductDetailUi>,
    ) {
        communications.observeProductDetailUi(owner, observer)
    }
}