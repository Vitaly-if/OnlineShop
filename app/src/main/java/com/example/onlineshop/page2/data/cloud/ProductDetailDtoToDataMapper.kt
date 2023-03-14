package com.example.onlineshop.page2.data.cloud

import com.example.onlineshop.page2.data.ProductDetailData

/**
 * @author Vitaly.N on 12.03.2023.
 */
class ProductDetailDtoToDataMapper : ProductDetailDTO.Mapper<ProductDetailData> {
    override fun map(
        name: String,
        description: String,
        rating: Float,
        numberReviews: Int,
        price: Float,
        colors: List<String>,
        imageUrls: List<String>
    ): ProductDetailData {
        return ProductDetailData(
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