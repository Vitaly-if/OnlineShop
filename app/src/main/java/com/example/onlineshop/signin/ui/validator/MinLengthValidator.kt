package com.example.onlineshop.signin.ui.validator

import com.example.core.presenter.UiValidator

/**
 * @author Vitaly.N on 04.03.2023.
 */
open class MinLengthValidator(
    errorMessage: String,
    private val minLength: Int
) : UiValidator.Abstract(errorMessage) {

    override fun isValid(text: String): Boolean {
        return text.length >= minLength
    }
}