package com.example.onlineshop.home.ui

import android.util.Log
import com.example.onlineshop.core.ItemUi
import com.example.onlineshop.core.MyView

/**
 * @author Vitaly.N on 10.03.2023.
 */
class LatestUi(
    private val id: String = "0",
    private val category: String,
    private val name: String,
    private val price: String,
    private val imageUrl: String,
) : ItemUi {
    override fun type(): Int = 1

    override fun show(vararg views: MyView) {
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