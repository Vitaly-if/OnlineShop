package com.example.onlineshop.core.domain

import com.example.core.domain.HandleError
import java.net.UnknownHostException

/**
 * @author Vitaly.N on 09.03.2023.
 */
class HandleDomainError : HandleError {

    override fun handle(error: Exception) =
        if (error is UnknownHostException)
            NoInternetConnectionException()
        else
            ServiceUnavailableException()
}
class NoInternetConnectionException : Exception()

class ServiceUnavailableException :Exception()