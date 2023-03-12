package com.example.onlineshop.signin.domain

/**
 * @author Vitaly.N on 06.03.2023.
 */
data class LoginDomain(
    private val login: String,
    private val password: String,
) {

    interface Mapper<T> {
        fun map(login: String, password: String): T

        class Matches(private val login: String, private val password: String) : Mapper<Boolean> {
            override fun map(login: String, password: String): Boolean {
                return this.login == login && this.password == password
            }
        }
        class Check(private val login: String) : Mapper<Boolean>{
            override fun map(login: String, password: String): Boolean {
                return this.login == login
            }
        }
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(login, password)
}