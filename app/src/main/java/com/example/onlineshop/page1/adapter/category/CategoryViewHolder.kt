package com.example.onlineshop.page1.adapter.category

import android.view.View
import com.example.onlineshop.R
import com.example.core.presenter.ItemUi
import com.example.core.adapter.GenericViewHolder

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