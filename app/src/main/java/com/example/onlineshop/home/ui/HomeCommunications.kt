package com.example.onlineshop.home.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.onlineshop.core.Communication

/**
 * @author Vitaly.N on 10.03.2023.
 */
interface HomeCommunications : ObserveHome {
    fun showLatest(listLatest: List<LatestUi>)
    fun showFlashSale(listFlashSaleUi: List<FlashSaleUi>)
    class Base(
        private val latestes: LatestListCommunication,
        private val flashSale: FlashSaleListCommunication
    ) : HomeCommunications {
        override fun showLatest(listLatest: List<LatestUi>) = latestes.map(listLatest)

        override fun showFlashSale(listFlashSaleUi: List<FlashSaleUi>) = flashSale.map(listFlashSaleUi)

        override fun observeLatestList(owner: LifecycleOwner, observer: Observer<List<LatestUi>>) {
            latestes.observe(owner, observer)
        }
        override fun observeFlashSaleList(
            owner: LifecycleOwner,
            observer: Observer<List<FlashSaleUi>>,
        ) {
            flashSale.observe(owner, observer)
        }
    }
}
interface ObserveHome {
    fun observeLatestList(owner: LifecycleOwner, observer: Observer<List<LatestUi>>)
    fun observeFlashSaleList(owner: LifecycleOwner, observer: Observer<List<FlashSaleUi>>)
}
interface LatestListCommunication : Communication.Mutable<List<LatestUi>> {
    class Base : Communication.Post<List<LatestUi>>(), LatestListCommunication
}
interface FlashSaleListCommunication : Communication.Mutable<List<FlashSaleUi>> {
    class Base : Communication.Post<List<FlashSaleUi>>(), FlashSaleListCommunication
}