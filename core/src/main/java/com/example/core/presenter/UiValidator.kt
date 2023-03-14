package com.example.core.presenter

/**
 * @author Vitaly.N on 04.03.2023.
 */
interface UiValidator {

    fun errorMessage(): String

    fun isValid(text: String): Boolean

    abstract class Abstract(private val message: String) : UiValidator {
        override fun errorMessage(): String {
            return message
        }
    }
}