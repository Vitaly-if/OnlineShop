package com.example.onlineshop.home.adapter.flashsale

import com.example.onlineshop.core.presenter.adapter.GenericAdapter
import com.example.onlineshop.core.presenter.adapter.ViewHolderFactoryChain

/**
 * @author Vitaly.N on 10.03.2023.
 */
class FlashSaleAdapter : GenericAdapter.Base(
    FlashSaleViewHolderFactoryChain(
        ViewHolderFactoryChain.Exception()
    )
)