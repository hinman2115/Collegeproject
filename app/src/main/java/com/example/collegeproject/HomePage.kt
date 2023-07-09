package com.example.collegeproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

private lateinit var firebaseAuth: FirebaseAuth
class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        val logout: Button = findViewById(R.id.btnLogout)
        firebaseAuth = FirebaseAuth.getInstance()

        logout.setOnClickListener {
            Toast.makeText(this, "Logged-Out", Toast.LENGTH_SHORT).show()
            firebaseAuth.signOut()
            startActivity(Intent(this,frontapp::class.java))
            finish()
        }
    }
}