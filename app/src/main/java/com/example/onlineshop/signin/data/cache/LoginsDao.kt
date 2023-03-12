package com.example.onlineshop.signin.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * @author Vitaly.N on 05.03.2023.
 */
@Dao
interface LoginsDao {

    @Query("SELECT * FROM logins_table")
    suspend fun allLogins(): List<LoginDAO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(loginDAO: LoginDAO)

    @Query("SELECT * FROM logins_table WHERE login = :login")
    suspend fun fetchLogin(login: String): LoginDAO?
}