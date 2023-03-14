package com.example.onlineshop.page1.ui

import android.util.Log

/**
 * @author Vitaly.N on 10.03.2023.
 */
class LatestUi(
    private val id: String = "0",
    private val category: String,
    private val name: String,
    private val price: String,
    private val imageUrl: String,
) : com.example.core.presenter.ItemUi {
    override fun type(): Int = 1

    override fun show(vararg views: com.example.core.presenter.MyView) {
        views[0].show(name)
        views[1].show(category)
        views[2].show(price)
        views[3].handleClick {
            Log.i("vital", "Click Latest $id")
        }
        views[4].loadImage(imageUrl)
    }

override fun id(): String = id

override fun content(): String = name

}