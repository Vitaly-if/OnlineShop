package com.example.onlineshop.page1.ui

/**
 * @author Vitaly.N on 11.03.2023.
 */
interface LatestIdStorage{

    interface Save {
        fun save(data: String)
    }

    interface Read {
        fun read(): String
    }

    interface Mutable : Save, Read

    class Base : Mutable {
        private var value = ""
        override fun save(data: String) {
            value = data
        }

        override fun read(): String = value
    }

}