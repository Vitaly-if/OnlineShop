package com.example.core.presenter

/**
 * @author Vitaly.N on 04.03.2023.
 */
class UiValidatorChain(
    private val base: UiValidator,
    private val next: UiValidator
) : UiValidator {

    private var baseValid = false

    override fun isValid(text: String): Boolean {
        baseValid = base.isValid(text)
        return if (baseValid) next.isValid(text) else false
    }

    override fun errorMessage(): String = if (baseValid) next.errorMessage() else base.errorMessage()
}