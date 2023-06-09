package com.example.onlineshop.page2.ui

import com.example.onlineshop.page2.domain.ProductDetailResult

/**
 * @author Vitaly.N on 13.03.2023.
 */
class DetailProductUiMapper: ProductDetailResult.Mapper<ProductDetailUi> {
    override fun map(errorMessage: String): ProductDetailUi {
       return ProductDetailUi(errorMessage, "",1f,1,1f, emptyList(), emptyList())
    }

    override fun map(productDetailUi: ProductDetailUi): ProductDetailUi {
        return productDetailUi
    }
}