package com.example.core.adapter

import android.view.ViewGroup
import com.example.core.presenter.ItemUi

/**
 * @author Vitaly.N on 08.03.2023.
 */
interface ViewHolderFactoryChain<T : ItemUi> {

    fun viewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T>

    class Exception<T : ItemUi> : ViewHolderFactoryChain<T> {
        override fun viewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> {
            throw IllegalStateException("unknown viewType $viewType")
        }
    }
}