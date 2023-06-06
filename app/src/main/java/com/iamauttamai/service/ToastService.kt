package com.iamauttamai.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.widget.Toast

/**
 * Created by AuttaphonL. on 06,June,2023
 */

class ToastService : Service() {

    private val handler = Handler()
    private lateinit var context: Context
    private var isServiceRunning = false

    private val toastRunnable = object : Runnable {
        override fun run() {
            if (isServiceRunning) {
                showToast("Hello, Toast!")
                handler.postDelayed(this, 5000L) // Delay of 5 seconds (5000 milliseconds)
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startToastHandler()
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        stopToastHandler()
    }

    private fun startToastHandler() {
        isServiceRunning = true
        handler.postDelayed(toastRunnable, 0)
    }

    private fun stopToastHandler() {
        isServiceRunning = false
        handler.removeCallbacks(toastRunnable)
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}