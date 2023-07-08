package com.example.myapplication.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters


class MyWorkManager(
    context: Context,
    params: WorkerParameters
) : Worker(context, params) {
    override fun doWork(): Result {
        // TODO add notification
        return Result.success()
    }
}