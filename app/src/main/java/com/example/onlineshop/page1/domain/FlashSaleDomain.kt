package com.example.onlineshop.page1.domain

/**
 * @author Vitaly.N on 09.03.2023.
 */
data class FlashSaleDomain(
    private val category: String,
    private val name: String,
    private val price: Float,
    private val discount: Int,
    private val imageUrl: String,
) {
    interface Mapper<T> {
        fun map(
            category: String,
            name: String,
            price: Float,
            discount: Int,
            imageUrl: String,
            id: String
        ): T
    }

    fun <T> map(mapper: Mapper<T>, id: String): T = mapper.map(
        category, name, price, discount, imageUrl, id)
}
