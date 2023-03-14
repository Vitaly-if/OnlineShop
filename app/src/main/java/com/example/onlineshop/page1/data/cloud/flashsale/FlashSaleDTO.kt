package com.example.onlineshop.page1.data.cloud.flashsale

import com.google.gson.annotations.SerializedName

/**
 * @author Vitaly.N on 09.03.2023.
 */
data class FlashSaleDTO(
    @SerializedName("category")
    private val category: String,
    @SerializedName("name")
    private val name: String,
    @SerializedName("price")
    private val price: Float,
    @SerializedName("discount")
    private val discount: Int,
    @SerializedName("image_url")
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
