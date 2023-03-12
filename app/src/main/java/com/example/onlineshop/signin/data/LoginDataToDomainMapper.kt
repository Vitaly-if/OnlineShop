package com.example.onlineshop.signin.data

import com.example.onlineshop.signin.domain.LoginDomain

/**
 * @author Vitaly.N on 06.03.2023.
 */
class LoginDataToDomainMapper: LoginData.Mapper<LoginDomain> {
    override fun map(login: String, password: String) = LoginDomain(login, password)
}