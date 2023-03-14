package com.example.onlineshop.page2.data

/**
 * @author Vitaly.N on 12.03.2023.
 */
data class ProductDetailData(
    private val name: String,
    private val description: String,
    private val rating: Float,
    private val numberReviews: Int,
    private val price: Float,
    private val colors: List<String>,
    private val imageUrls: List<String>
) {
    interface Mapper<T> {
        fun map(
            name: String,
            description: String,
            rating: Float,
            numberReviews: Int,
            price: Float,
            colors: List<String>,
            imageUrls: List<String>
        ): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(
        name, description, rating, numberReviews, price, colors, imageUrls
    )
}