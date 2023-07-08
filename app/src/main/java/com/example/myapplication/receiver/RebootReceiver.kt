package com.example.myapplication.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.myapplication.Dependencies
import com.example.myapplication.database.BootCounter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class RebootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        GlobalScope.launch {
            val dataBase = Dependencies.init(context)
            val bootCounter = dataBase.bootCounterDao.getLatestBootCounter()
            val newCounter = if (bootCounter?.counter == null) 0 else bootCounter.counter +1
            val updated = BootCounter(counter = newCounter, timestamp = System.currentTimeMillis())
            dataBase.bootCounterDao.insert(updated)
        }
    }
}