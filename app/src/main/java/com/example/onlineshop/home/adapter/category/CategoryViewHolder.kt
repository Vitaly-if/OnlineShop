package com.example.onlineshop.home.adapter.category

import android.view.View
import com.example.onlineshop.R
import com.example.onlineshop.core.ItemUi
import com.example.onlineshop.core.presenter.adapter.GenericViewHolder

/**
 * @author Vitaly.N on 08.03.2023.
 */
class CategoryViewHolder(view: View) : GenericViewHolder<ItemUi>(view) {

    override fun bind(item: ItemUi) = with(itemView) {
        item.show(
            findViewById(R.id.nameCategoryTextView),
            findViewById(R.id.itemCategoryImageButton)
        )
    }
}