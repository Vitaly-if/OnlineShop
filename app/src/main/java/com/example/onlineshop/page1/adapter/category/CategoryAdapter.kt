package com.example.onlineshop.page1.adapter.category

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