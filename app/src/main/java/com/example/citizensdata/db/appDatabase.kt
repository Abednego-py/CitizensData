package com.example.citizensdata.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [appEntity::class], version = 1)
abstract class appDatabase : RoomDatabase() {
    abstract fun appDao() : appDao
}