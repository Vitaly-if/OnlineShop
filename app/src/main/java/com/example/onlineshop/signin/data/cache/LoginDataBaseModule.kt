package com.example.onlineshop.signin.data.cache

import android.content.Context
import androidx.room.Room

/**
 * @author Vitaly.N on 05.03.2023.
 */
interface LoginCacheModule {

    fun provideDataBase(): LoginDataBase

    class Base(private val context: Context) : LoginCacheModule {

        private val database by lazy {
            return@lazy Room.databaseBuilder(
                context,
                LoginDataBase::class.java,
                "logins_database"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
        override fun provideDataBase(): LoginDataBase = database
    }
}