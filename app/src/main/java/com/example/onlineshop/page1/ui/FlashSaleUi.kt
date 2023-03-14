package com.example.onlineshop.page1.ui

import android.util.Log
import com.example.core.presenter.ItemUi
import com.example.core.presenter.MyView
import com.example.onlineshop.page1.FlashSaleNavigation

/**
 * @author Vitaly.N on 10.03.2023.
 */
class FlashSaleUi(
    private val id: String,
    private val category: String,
    private val name: String,
    private val price: String,
    private val discount: String,
    private val imageUrl: String,
    private val flashSaleNavigation: FlashSaleNavigation.Base
) : ItemUi {
    override fun type(): Int = 1

    override fun show(vararg views: MyView) {
        views[0].show(name)
        views[1].show(category)
        views[2].show(discount)
        views[3].show(price)
        views[4].handleClick {
            Log.i("vital", "Click FlashSale $id")
        }
        views[5].loadImage(imageUrl)
        views[6].handleClick{
            flashSaleNavigation.map(id.toInt())
            Log.i("vital", "Click FlashSaleCard $id")
        }
    }

    override fun id(): String = id

    override fun content(): String = category

}
