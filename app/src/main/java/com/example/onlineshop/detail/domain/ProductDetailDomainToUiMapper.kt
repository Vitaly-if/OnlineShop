package com.example.onlineshop.detail.domain

import com.example.onlineshop.detail.ui.ProductDetailUi

/**
 * @author Vitaly.N on 12.03.2023.
 */
class ProductDetailDomainToUiMapper : ProductDetailDomain.Mapper<ProductDetailUi> {
    override fun map(
        name: String,
        description: String,
        rating: Float,
        numberReviews: Int,
        price: Float,
        colors: List<String>,
        imageUrls: List<String>
    ): ProductDetailUi {
        return ProductDetailUi(
            name,
            description,
            rating,
            numberReviews,
            price,
            colors,
            imageUrls
        )
    }
}