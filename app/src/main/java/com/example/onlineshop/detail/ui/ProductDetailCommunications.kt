package com.example.onlineshop.detail.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.onlineshop.core.Communication

/**
 * @author Vitaly.N on 12.03.2023.
 */
interface ProductDetailCommunications : ObserveProductDetail {

    fun showListImage(images: List<String>)

    fun showListColor(colors: List<String>)

    fun showCard(source: ProductDetailUi)

    class Base(
        private val imagesList: ImagesProductListCommunication,
        private val colorsList: ColorsProductListCommunication,
        private val productDetail: ProductDetailUiCommunication,
    ) : ProductDetailCommunications {
        override fun showListImage(images: List<String>) = imagesList.map(images)

        override fun showListColor(colors: List<String>) = colorsList.map(colors)

        override fun showCard(source: ProductDetailUi) = productDetail.map(source)

        override fun observeImageList(owner: LifecycleOwner, observer: Observer<List<String>>) =
            imagesList.observe(owner, observer)

        override fun observeColorList(owner: LifecycleOwner, observer: Observer<List<String>>) =
            colorsList.observe(owner, observer)

        override fun observeProductDetailUi(
            owner: LifecycleOwner,
            observer: Observer<ProductDetailUi>,
        ) {
            productDetail.observe(owner, observer)
        }
    }
}

interface ObserveProductDetail {

    fun observeImageList(owner: LifecycleOwner, observer: Observer<List<String>>)
    fun observeColorList(owner: LifecycleOwner, observer: Observer<List<String>>)
    fun observeProductDetailUi(owner: LifecycleOwner, observer: Observer<ProductDetailUi>)
}

interface ProductDetailUiCommunication : Communication.Mutable<ProductDetailUi> {
    class Base : Communication.Ui<ProductDetailUi>(), ProductDetailUiCommunication
}

interface ImagesProductListCommunication : Communication.Mutable<List<String>> {
    class Base : Communication.Ui<List<String>>(), ImagesProductListCommunication
}

interface ColorsProductListCommunication : Communication.Mutable<List<String>> {
    class Base : Communication.Ui<List<String>>(), ColorsProductListCommunication
}