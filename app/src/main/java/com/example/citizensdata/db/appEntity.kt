package com.example.citizensdata.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class appEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var name: String,
    var Address: String,
    var Age: Int,
    var occupation: String,
    var marital_status: String
    ) : Parcelable

