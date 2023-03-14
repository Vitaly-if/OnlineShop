package com.example.onlineshop.home.adapter.flashsale

import com.example.core.adapter.GenericAdapter
import com.example.core.adapter.ViewHolderFactoryChain

/**
 * @author Vitaly.N on 10.03.2023.
 */
class FlashSaleAdapter : GenericAdapter.Base(
    FlashSaleViewHolderFactoryChain(
        ViewHolderFactoryChain.Exception()
    )
)