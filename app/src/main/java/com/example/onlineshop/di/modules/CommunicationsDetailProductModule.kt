package com.example.onlineshop.di.modules

import com.example.onlineshop.page2.ui.*
import dagger.Module
import dagger.Provides

/**
 * @author Vitaly.N on 14.03.2023.
 */
@Module
class CommunicationsDetailProductModule {

    @Provides
    fun provideCommunicationDetailProduct(): ProductDetailCommunications {
        return ProductDetailCommunications.Base(
            ImagesProductListCommunication.Base(),
            ColorsProductListCommunication.Base(),
            ProductDetailUiCommunication.Base()
        )
    }

    @Provides
    fun privideDetailProductUiMapper(): DetailProductUiMapper {
        return DetailProductUiMapper()
    }


}