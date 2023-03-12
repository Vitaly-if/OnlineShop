package com.example.onlineshop.signin.domain

/**
 * @author Vitaly.N on 06.03.2023.
 */
sealed class LoginResult{
    object Success: LoginResult()
    object Failure: LoginResult()
}
