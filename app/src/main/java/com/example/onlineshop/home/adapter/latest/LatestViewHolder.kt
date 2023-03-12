package com.example.onlineshop.home.adapter.latest

import android.view.View
import com.example.onlineshop.R
import com.example.onlineshop.core.ItemUi
import com.example.onlineshop.core.presenter.adapter.GenericViewHolder

/**
 * @author Vitaly.N on 10.03.2023.
 */
class LatestViewHolder(view: View) : GenericViewHolder<ItemUi>(view) {

    override fun bind(item: ItemUi) = with(itemView) {
        item.show(
            findViewById(R.id.nameLatestTextView),
            findViewById(R.id.nameCategoryLatestTextView),
            findViewById(R.id.priceLatestTextView),
            findViewById(R.id.addToBasketLatestImageButton),
            findViewById(R.id.latestImageView)
        )
    }
}