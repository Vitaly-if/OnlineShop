package com.example.onlineshop.core

/**
 * @author Vitaly.N on 08.03.2023.
 */
interface ItemUi{

    fun type(): Int

    fun show(vararg views: MyView)

    fun id(): String

    fun content(): String
}