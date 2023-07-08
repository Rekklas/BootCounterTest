package com.example.myapplication

import android.app.Application
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.myapplication.workmanager.MyWorkManager
import java.util.concurrent.TimeUnit


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Dependencies.init(this)
        val periodicWorkRequest = PeriodicWorkRequest
            .Builder(MyWorkManager::class.java,15,TimeUnit.MINUTES)
            .build()

        WorkManager.getInstance(applicationContext).enqueue(periodicWorkRequest)
    }
}