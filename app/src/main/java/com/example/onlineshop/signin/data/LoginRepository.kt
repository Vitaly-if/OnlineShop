package com.example.onlineshop.signin.data

import com.example.onlineshop.signin.data.cache.LoginCacheDataSource
import com.example.onlineshop.signin.domain.LoginDomain

/**
 * @author Vitaly.N on 06.03.2023.
 */
interface LoginRepository {

    suspend fun insertLogin(login: String, password: String)

    suspend fun fetchLogin(login: String): LoginDomain

    class Base(
        private val loginCacheDataSource: LoginCacheDataSource,
        private val dataToDomainMapper: LoginData.Mapper<LoginDomain>,
    ) : LoginRepository {
        override suspend fun insertLogin(login: String, password: String) {
            loginCacheDataSource.insertLogin(login, password)
        }

        override suspend fun fetchLogin(login: String): LoginDomain {
            return loginCacheDataSource.fetchLogin(login).map(dataToDomainMapper)
        }
    }
}