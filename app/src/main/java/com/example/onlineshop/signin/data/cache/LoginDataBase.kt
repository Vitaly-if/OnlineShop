package com.example.onlineshop.signin.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author Vitaly.N on 05.03.2023.
 */
@Database(entities = [LoginDAO::class], version = 1)
abstract class LoginDataBase : RoomDatabase() {

    abstract fun loginsDao() : LoginsDao
}