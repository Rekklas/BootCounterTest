package com.example.myapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "boot_counter")
data class BootCounter(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "counter")
    val counter: Int = 0,

    @ColumnInfo(name = "timestamp")
    val timestamp: Long = 0L
)