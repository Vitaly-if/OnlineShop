package com.example.core.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.core.presenter.ItemUi

/**
 * @author Vitaly.N on 08.03.2023.
 */
class DiffUtilCallback<T : ItemUi>(
    private val oldList: List<T>,
    private val newList: List<T>,
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id() == newList[newItemPosition].id()

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].content() == newList[newItemPosition].content()
}