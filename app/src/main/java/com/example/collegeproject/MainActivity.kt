package com.example.collegeproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.play.core.integrity.IntegrityTokenRequest
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val progressBar: ProgressBar = findViewById(R.id.progress)
        val loginbtn: Button = findViewById(R.id.loginbtn)
        val signinbtn: TextView = findViewById(R.id.singuptext)

        signinbtn.setOnClickListener {
            startActivity(Intent(this,Registration_form::class.java))
            finish()
        }

        loginbtn.setOnClickListener {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,HomePage::class.java))
            progressBar.isVisible
            finish()
        }
    }
}