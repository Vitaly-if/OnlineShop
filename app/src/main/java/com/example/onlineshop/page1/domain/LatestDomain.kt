package com.example.onlineshop.page1.domain

/**
 * @author Vitaly.N on 09.03.2023.
 */
data class LatestDomain(
    private val category: String,
    private val name: String,
    private val price: Float,
    private val imageUrl: String
) {
    interface Mapper<T> {
        fun map(
            category: String,
            name: String,
            price: Float,
            imageUrl: String,
            id: String
        ): T
    }

    fun <T> map(mapper: Mapper<T>, id: String): T = mapper.map(
        category, name, price, imageUrl, id)
}