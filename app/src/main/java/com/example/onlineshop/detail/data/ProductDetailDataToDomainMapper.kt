package com.example.onlineshop.detail.data

import com.example.onlineshop.detail.domain.ProductDetailDomain

/**
 * @author Vitaly.N on 12.03.2023.
 */
class ProductDetailDataToDomainMapper : ProductDetailData.Mapper<ProductDetailDomain> {
    override fun map(
        name: String,
        description: String,
        rating: Float,
        numberReviews: Int,
        price: Float,
        colors: List<String>,
        imageUrls: List<String>
    ): ProductDetailDomain {
        return ProductDetailDomain(
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