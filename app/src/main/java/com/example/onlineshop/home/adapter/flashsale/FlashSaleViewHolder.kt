package com.example.onlineshop.home.adapter.flashsale

import android.view.View
import com.example.onlineshop.R
import com.example.onlineshop.core.ItemUi
import com.example.onlineshop.core.presenter.adapter.GenericViewHolder

/**
 * @author Vitaly.N on 10.03.2023.
 */
class FlashSaleViewHolder(view: View) : GenericViewHolder<ItemUi>(view) {

    override fun bind(item: ItemUi) = with(itemView) {
        item.show(
            findViewById(R.id.nameFlashSaleTextView),
            findViewById(R.id.nameCategoryFlashSaleTextView),
            findViewById(R.id.discountTextView),
            findViewById(R.id.priceFlashSaleTextView),
            findViewById(R.id.addToBasketFlashSaleImageButton),
            findViewById(R.id.flashSaleImageView),
            findViewById(R.id.flashSaleContainerCardView)
        )
    }
}