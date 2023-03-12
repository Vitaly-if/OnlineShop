package com.example.onlineshop.home.adapter.flashsale

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.onlineshop.R
import com.example.onlineshop.core.ItemUi
import com.example.onlineshop.core.presenter.adapter.GenericViewHolder
import com.example.onlineshop.core.presenter.adapter.ViewHolderFactoryChain

/**
 * @author Vitaly.N on 10.03.2023.
 */
class FlashSaleViewHolderFactoryChain(
    private val viewHolderFactoryChain: ViewHolderFactoryChain<ItemUi>,
) : ViewHolderFactoryChain<ItemUi> {

    override fun viewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<ItemUi> =
        if (viewType == 1)
            FlashSaleViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_flash_sale, parent, false)
            )
        else viewHolderFactoryChain.viewHolder(parent, viewType)
}