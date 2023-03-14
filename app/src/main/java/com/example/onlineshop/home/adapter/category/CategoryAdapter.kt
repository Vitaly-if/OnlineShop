package com.example.onlineshop.home.adapter.category

import com.example.core.adapter.GenericAdapter
import com.example.core.adapter.ViewHolderFactoryChain

/**
 * @author Vitaly.N on 08.03.2023.
 */
class CategoryAdapter : GenericAdapter.Base(
    CategoryViewHolderFactoryChain(
        ViewHolderFactoryChain.Exception()
    )
)