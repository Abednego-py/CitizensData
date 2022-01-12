package com.example.citizensdata.db

import androidx.room.*


@Dao
interface appDao {
    @Insert
    fun insert(appEntity: appEntity): Long

    @Query("select * from appEntity")
    fun retrieve(): List<appEntity>

    @Update
    fun update(appEntity: appEntity)

    @Delete
    fun delete(appEntity: appEntity)
}