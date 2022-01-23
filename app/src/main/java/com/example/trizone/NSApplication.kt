package com.example.trizone

import android.app.Application
import androidx.room.Room
import com.example.trizone.database.NSDatabase

/*Created by Maneesha on 22/01/2022*/

class NSApplication : Application() {

    companion object DatabaseSetup {
        var database: NSDatabase? = null
        private var app: NSApplication? = null
        fun getApp(): NSApplication? {
            return app
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        database = Room.databaseBuilder(
            applicationContext,
            NSDatabase::class.java, "nsroom"
        ).build()
    }


}

