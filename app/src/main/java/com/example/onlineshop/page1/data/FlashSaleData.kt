package com.example.onlineshop.page1.data

/**
 * @author Vitaly.N on 09.03.2023.
 */
data class FlashSaleData(
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
        ): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(
        category, name, price, discount, imageUrl)
}
