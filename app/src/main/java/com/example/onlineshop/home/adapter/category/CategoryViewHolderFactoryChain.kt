package com.example.onlineshop.home.adapter.category

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.onlineshop.R
import com.example.core.presenter.ItemUi
import com.example.core.adapter.GenericViewHolder
import com.example.core.adapter.ViewHolderFactoryChain

/**
 * @author Vitaly.N on 08.03.2023.
 */
class CategoryViewHolderFactoryChain(
private val viewHolderFactoryChain: ViewHolderFactoryChain<ItemUi>
) : ViewHolderFactoryChain<ItemUi> {

    override fun viewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<ItemUi> =
        if (viewType == 1)
            CategoryViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_category, parent, false)
            )
        else viewHolderFactoryChain.viewHolder(parent, viewType)
}