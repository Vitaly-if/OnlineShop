package com.example.core.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.core.presenter.ItemUi
import com.example.core.presenter.Mapper

/**
 * @author Vitaly.N on 08.03.2023.
 */
abstract class GenericAdapter<T : ItemUi>(
    private val viewHolderFactoryChain: ViewHolderFactoryChain<T>
) : RecyclerView.Adapter<GenericViewHolder<T>>(), Mapper.Unit<List<T>> {

    private val list: MutableList<T> = mutableListOf()

    override fun getItemViewType(position: Int): Int = list[position].type()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> =
        viewHolderFactoryChain.viewHolder(parent, viewType)

    override fun onBindViewHolder(holder: GenericViewHolder<T>, position: Int) =
        holder.bind(list[position])

    override fun getItemCount(): Int = list.size

    override fun map(data: List<T>) {
        val diffCallback = DiffUtilCallback(list, data)
        val result = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(data)
        result.dispatchUpdatesTo(this)
    }

    abstract class Base(viewHolderFactoryChain: ViewHolderFactoryChain<ItemUi>) :
        GenericAdapter<ItemUi>(viewHolderFactoryChain)
}