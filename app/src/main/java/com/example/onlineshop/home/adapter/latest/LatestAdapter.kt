package com.example.onlineshop.home.adapter.latest

import com.example.core.adapter.GenericAdapter
import com.example.core.adapter.ViewHolderFactoryChain

/**
 * @author Vitaly.N on 10.03.2023.
 */
class LatestAdapter : GenericAdapter.Base(
    LatestViewHolderFactoryChain(
        ViewHolderFactoryChain.Exception()
    )
)