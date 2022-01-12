package com.example.citizensdata

import android.app.Application
import androidx.room.Room
import com.example.citizensdata.db.appDatabase

class MainApp : Application() {
    lateinit var database : appDatabase

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this,
            appDatabase::class.java, "todo_db")
            .allowMainThreadQueries().build()
    }
}