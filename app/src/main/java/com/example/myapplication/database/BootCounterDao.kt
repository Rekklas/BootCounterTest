package com.example.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
abstract class BootCounterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(item: BootCounter): Long

    @Query("SELECT * FROM boot_counter ORDER BY id DESC LIMIT 1")
    abstract suspend fun getLatestBootCounter(): BootCounter?

    @Query("SELECT * FROM boot_counter ")
    abstract fun getBootCounterLiveData(): LiveData<List<BootCounter>>
}