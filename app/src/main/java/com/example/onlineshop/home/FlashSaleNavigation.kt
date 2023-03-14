package com.example.onlineshop.home

import com.example.core.presenter.Communication

/**
 * @author Vitaly.N on 11.03.2023.
 */
interface FlashSaleNavigation {

    interface Observe : com.example.core.presenter.Communication.Observe<Int>
    interface Update : com.example.core.presenter.Communication.Mutate<Int>

    class Base : com.example.core.presenter.Communication.Ui<Int>(), Observe, Update
}