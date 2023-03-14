package com.example.core.presenter

import android.view.View
import androidx.annotation.DrawableRes

/**
 * @author Vitaly.N on 08.03.2023.
 */
interface MyView {

    fun show(text: CharSequence) = Unit

    fun show(textId: Int) = Unit

    fun loadImage(url: String) = Unit

    fun showImageResource(@DrawableRes id: Int) = Unit

    fun enable(enabled: Boolean) = Unit

    fun check(checked: Boolean) = Unit

    fun handleClick(listener: View.OnClickListener) = Unit

    fun loadBackground(color: String) = Unit

    fun increase() = Unit
}