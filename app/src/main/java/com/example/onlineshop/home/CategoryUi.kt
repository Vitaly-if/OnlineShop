package com.example.onlineshop.home

import android.util.Log
import com.example.core.presenter.ItemUi
import com.example.core.presenter.MyView

/**
 * @author Vitaly.N on 08.03.2023.
 */
class CategoryUi(
    private val id: String,
    private val text: String,
    private val image: Int
) : com.example.core.presenter.ItemUi {

    override fun type(): Int = 1

    override fun show(vararg views: com.example.core.presenter.MyView) {
        views[0].show(text)
        views[1].handleClick {
            Log.i("vital", "Click category $text")
        }
        views[1].showImageResource(image)
    }

    override fun id(): String = id

    override fun content(): String = text

}