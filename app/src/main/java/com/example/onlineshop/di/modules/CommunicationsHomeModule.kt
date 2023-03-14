package com.example.onlineshop.di.modules

import com.example.onlineshop.page1.ui.FlashSaleListCommunication
import com.example.onlineshop.page1.ui.HomeCommunications
import com.example.onlineshop.page1.ui.LatestListCommunication
import dagger.Module
import dagger.Provides

/**
 * @author Vitaly.N on 14.03.2023.
 */
@Module
class CommunicationsHomeModule {

    @Provides
    fun provideCommunicationHome(): HomeCommunications {
        return HomeCommunications.Base(
            LatestListCommunication.Base(),
            FlashSaleListCommunication.Base()
        )
    }
}