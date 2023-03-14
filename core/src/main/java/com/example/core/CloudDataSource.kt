package com.example.core

import com.example.core.domain.HandleError

/**
 * @author Vitaly.N on 09.03.2023.
 */
interface CloudDataSource {

    suspend fun <T> handle(block: suspend () -> T): T

    abstract class Abstract(
        private val handleError: HandleError
    ) : CloudDataSource {

        override suspend fun <T> handle(block: suspend () -> T): T =
            try {
                block.invoke()
            } catch (error: Exception) {
                throw handleError.handle(error)
            }
    }
}