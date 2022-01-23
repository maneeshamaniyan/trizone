package com.example.trizone.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
/*Created by Maneesha on 9/01/2022*/

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "user_name") val userName: String?,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "password") val password: String?,
    @ColumnInfo(name = "phone_number") val phoneNumber: String?

)
