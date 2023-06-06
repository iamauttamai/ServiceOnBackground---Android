package com.iamauttamai.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Start the ToastService
        val serviceIntent = Intent(this, ToastService::class.java)
        startService(serviceIntent)
//        stopService(serviceIntent)

    }
}