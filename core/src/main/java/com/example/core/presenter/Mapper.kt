package com.example.core.presenter

/**
 * @author Vitaly.N on 04.03.2023.
 */
interface Mapper<R, S> {

    fun map(source: S): R

    interface Unit<S> : Mapper<kotlin.Unit, S>
}