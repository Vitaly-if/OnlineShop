package com.example.onlineshop.signin.ui.validator

import com.example.core.presenter.UiValidator

/**
 * @author Vitaly.N on 06.03.2023.
 */
class EmailValidator(private val errorMessage: String) : UiValidator {

    override fun errorMessage(): String {
        return errorMessage
    }

    override fun isValid(text: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches();
    }
}