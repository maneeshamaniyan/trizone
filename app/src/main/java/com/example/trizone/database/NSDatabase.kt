package com.example.trizone.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
/*Created by Maneesha on 19/01/2022*/

@Database(entities = [User::class], version = 1 )
abstract class  NSDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao

    @Volatile
    private var database: NSDatabase? = null

    fun getInstance(context: Context): NSDatabase {
        synchronized(this) {
            var instance = database

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    NSDatabase::class.java,
                    "nsroom.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                database = instance
            }
            return instance
        }
    }
    fun destroyInstance() {
        database = null
    }
    private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
        NSDatabase::class.java, "nsroom.db")
        .build()

}