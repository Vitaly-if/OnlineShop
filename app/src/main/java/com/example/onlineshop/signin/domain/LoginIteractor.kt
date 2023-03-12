package com.example.onlineshop.signin.domain

import com.example.onlineshop.signin.data.LoginRepository

/**
 * @author Vitaly.N on 06.03.2023.
 */
interface LoginIteractor {

    suspend fun insertLogin(login: String, password: String)

    suspend fun fetchLogin(login: String, password: String): LoginResult

    suspend fun checkLogin(login: String): LoginResult

    class Base(
        private val repository: LoginRepository,
    ) : LoginIteractor {

        override suspend fun insertLogin(login: String, password: String) {
            repository.insertLogin(login, password)
        }

        override suspend fun fetchLogin(login: String, password: String): LoginResult {
            val loginDomain = repository.fetchLogin(login)
            var result = LoginResult.Failure as LoginResult
            if (loginDomain.map(LoginDomain.Mapper.Matches(login, password)))
                result = LoginResult.Success
            return result
        }

        override suspend fun checkLogin(login: String) : LoginResult {
            val loginDomain = repository.fetchLogin(login)
            var result = LoginResult.Success as LoginResult
            if (loginDomain.map(LoginDomain.Mapper.Check(login)))
                result = LoginResult.Failure
            return result
        }
    }
}