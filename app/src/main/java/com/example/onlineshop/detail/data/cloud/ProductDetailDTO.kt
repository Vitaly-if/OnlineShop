package com.example.onlineshop.detail.data.cloud

import com.google.gson.annotations.SerializedName

/**
 * @author Vitaly.N on 12.03.2023.
 */
data class ProductDetailDTO(
    @SerializedName("name")
    private val name: String,
    @SerializedName("description")
    private val description: String,
    @SerializedName("rating")
    private val rating: Float,
    @SerializedName("number_of_reviews")
    private val numberReviews: Int,
    @SerializedName("price")
    private val price: Float,
    @SerializedName("colors")
    private val colors: List<String>,
    @SerializedName("image_urls")
    private val imageUrls: List<String>,
) {
    interface Mapper<T> {
        fun map(
            name: String,
            description: String,
            rating: Float,
            numberReviews: Int,
            price: Float,
            colors: List<String>,
            imageUrls: List<String>,
        ): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(
        name, description, rating, numberReviews, price, colors, imageUrls
    )
}

