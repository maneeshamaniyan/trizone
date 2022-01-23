package com.example.trizone.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
/*Created by Maneesha on 9/01/2022*/
@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE user_name LIKE :userName AND " +
            "password LIKE :password LIMIT 1")
    fun findByName(userName: String, password: String): User

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

}