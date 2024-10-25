package com.example.listadetarefas

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class NotificacaoWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        // Código para exibir a notificação
        return Result.success()
    }
}
