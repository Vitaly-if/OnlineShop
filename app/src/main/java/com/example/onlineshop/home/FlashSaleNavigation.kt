package com.example.onlineshop.home

import com.example.onlineshop.core.Communication

/**
 * @author Vitaly.N on 11.03.2023.
 */
interface FlashSaleNavigation {

    interface Observe : Communication.Observe<Int>
    interface Update : Communication.Mutate<Int>

    class Base : Communication.Ui<Int>(), Observe, Update
}