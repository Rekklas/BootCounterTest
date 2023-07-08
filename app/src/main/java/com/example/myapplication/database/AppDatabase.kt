package com.example.myapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BootCounter::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
	abstract val bootCounterDao: BootCounterDao
}