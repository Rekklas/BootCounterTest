package com.example.myapplication

import android.content.Context
import androidx.room.Room
import com.example.myapplication.database.AppDatabase

object Dependencies {
    fun init(context: Context) : AppDatabase {
        return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "database.db")
            .createFromAsset("room_article.db")
            .build()
    }
}