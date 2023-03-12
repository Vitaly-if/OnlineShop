package com.example.onlineshop.core.data

/**
 * @author Vitaly.N on 09.03.2023.
 */
interface HandleError {

    fun handle(e: Exception): Exception

}