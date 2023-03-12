package com.example.onlineshop.signin.ui.validator

/**
 * @author Vitaly.N on 04.03.2023.
 */
class EmptinessValidator(errorMessage: String) : MinLengthValidator(errorMessage, 1)