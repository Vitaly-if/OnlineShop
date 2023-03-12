package com.example.onlineshop.detail.ui

import com.example.onlineshop.databinding.FragmentDetailProductBinding

/**
 * @author Vitaly.N on 12.03.2023.
 */
class CardProductUi (
    private val binding : FragmentDetailProductBinding
) : ProductDetailUi.Mapper<Unit> {
    override fun map(
        name: String,
        description: String,
        rating: Float,
        numberReviews: Int,
        price: Float,
        colors: List<String>,
        imageUrls: List<String>
    ) {
        TODO("Not yet implemented")
    }

}