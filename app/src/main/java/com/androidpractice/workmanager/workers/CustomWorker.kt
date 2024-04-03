package com.androidpractice.workmanager.workers

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.androidpractice.workmanager.di.DemoApi
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject


@HiltWorker
class CustomWorker @AssistedInject constructor(
    @Assisted private val api: DemoApi,
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters
): CoroutineWorker(
    context,
    workerParameters
) {
    override suspend fun doWork(): Result {
        try {
            val response = api.getPost()
            return if(response.isSuccessful){
                Result.success()
            } else {
                Result.retry()
            }

        } catch (e: Exception) {
           return Result.failure()

        }

    }
}