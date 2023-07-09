package com.example.collegeproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen2)

        Handler().postDelayed(Runnable {
            startActivity(Intent(this,frontapp::class.java))
            finish()
        },2800)
    }
}