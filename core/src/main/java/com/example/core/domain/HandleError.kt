package com.example.core.domain

/**
 * @author Vitaly.N on 09.03.2023.
 */
interface HandleError {

    fun handle(e: Exception): Exception

}