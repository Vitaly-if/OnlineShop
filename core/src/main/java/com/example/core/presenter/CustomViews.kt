package com.example.core.presenter

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Color
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.squareup.picasso.Picasso

/**
 * @author Vitaly.N on 04.03.2023.
 */
interface CustomTextInputLayout {

    fun changeErrorEnabled(enabled: Boolean)

    fun showError(errorMessage: String)
}

class BaseCustomTextInputLayout : TextInputLayout, CustomTextInputLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun changeErrorEnabled(enabled: Boolean) {
        isErrorEnabled = enabled
    }

    override fun showError(errorMessage: String) {
        error = errorMessage
    }
}

interface CustomTextInputEditText {

    fun showText(text: String)
}

class BaseCustomTextInputEditText : TextInputEditText, CustomTextInputEditText {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun showText(text: String) {
        setText(text)
    }
}

class MyTextView : androidx.appcompat.widget.AppCompatTextView, MyView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun show(text: CharSequence) {
        setText(text)
    }

    override fun show(textId: Int) {
        setText(textId)
    }
}

class MyImageButton : androidx.appcompat.widget.AppCompatImageButton, MyView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun enable(enabled: Boolean) {
        isEnabled = enabled
    }

    override fun handleClick(listener: OnClickListener) {
        setOnClickListener(listener)
    }

    override fun showImageResource(id: Int) {
        setImageResource(id)
    }

}

class MyImageView : androidx.appcompat.widget.AppCompatImageView, MyView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun loadImage(url: String) {
        Picasso.get().load(url).into(this)
    }

    override fun increase() {
        val density = Resources.getSystem().displayMetrics.density
        layoutParams.height = 65 * density.toInt()
        layoutParams.width = 123 * density.toInt()
    }
    override fun showImageResource(id: Int) {
        setImageResource(id)
    }

}

class MyCardView : com.google.android.material.card.MaterialCardView, MyView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun handleClick(listener: OnClickListener) {
        setOnClickListener(listener)
    }
}

class MyButton : androidx.appcompat.widget.AppCompatButton, MyView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun enable(enabled: Boolean) {
        isEnabled = enabled
    }

    override fun handleClick(listener: OnClickListener) {
        setOnClickListener(listener)
    }

    override fun loadBackground(color: String) {
        backgroundTintList = ColorStateList.valueOf(Color.parseColor(color))
    }
}
