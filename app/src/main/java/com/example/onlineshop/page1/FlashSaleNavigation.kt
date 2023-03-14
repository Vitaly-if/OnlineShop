package com.example.onlineshop.page1

import com.example.core.presenter.Communication

/**
 * @author Vitaly.N on 11.03.2023.
 */
interface FlashSaleNavigation {

    interface Observe : Communication.Observe<Int>
    interface Update : Communication.Mutate<Int>
    class Base : Communication.Ui<Int>(), Observe, Update
}