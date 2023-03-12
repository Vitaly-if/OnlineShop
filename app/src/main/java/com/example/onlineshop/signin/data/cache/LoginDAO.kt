package com.example.onlineshop.signin.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Vitaly.N on 05.03.2023.
 */
@Entity(tableName = "logins_table")
data class LoginDAO(
    @PrimaryKey @ColumnInfo(name = "login") val login: String,
    @ColumnInfo(name = "password") val password: String,
)