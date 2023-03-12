package com.example.onlineshop.signin.data.cache

import com.example.onlineshop.signin.data.LoginData

/**
 * @author Vitaly.N on 06.03.2023.
 */
interface LoginCacheDataSource {

    suspend fun insertLogin(login: String, password: String)

    suspend fun fetchLogin(login: String): LoginData

    class Base(
        private val dao: LoginsDao,
    ) : LoginCacheDataSource {
        override suspend fun insertLogin(login: String, password: String) {
            dao.insert(LoginDAO(login, password))
        }

        override suspend fun fetchLogin(login: String): LoginData {
            val loginDao = dao.fetchLogin(login)
            return LoginData(loginDao?.login ?: "", loginDao?.password ?: "")
        }
    }
}