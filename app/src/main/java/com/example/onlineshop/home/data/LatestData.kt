package com.example.onlineshop.home.data

/**
 * @author Vitaly.N on 09.03.2023.
 */
data class LatestData(
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
            imageUrl: String
        ): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(
        category, name, price, imageUrl)
}
