package com.example.collegeproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class frontapp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frontapp)
        val SignIn: TextView = findViewById(R.id.btnsignIn)
        val SignUp: TextView = findViewById(R.id.btnsignUp)

        SignIn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        SignUp.setOnClickListener {
            startActivity(Intent(this,Registration_form::class.java))
            finish()
        }
    }
}