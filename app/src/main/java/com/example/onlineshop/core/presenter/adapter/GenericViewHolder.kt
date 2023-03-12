package com.example.onlineshop.core.presenter.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.core.ItemUi

/**
 * @author Vitaly.N on 08.03.2023.
 */
abstract class GenericViewHolder<T : ItemUi>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(item: T)
}