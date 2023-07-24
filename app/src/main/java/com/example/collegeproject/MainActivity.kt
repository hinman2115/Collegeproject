package com.example.collegeproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
//    var progressBar: ProgressBar = findViewById(R.id.progress)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val forget :TextView = findViewById(R.id.Forgotpass)
        val loginbtn: Button = findViewById(R.id.loginbtn)
        val signinbtn: TextView = findViewById(R.id.singuptext)
        val emailId: EditText = findViewById(R.id.logEmail)
        val password: EditText = findViewById(R.id.logPassword)

        firebaseAuth = FirebaseAuth.getInstance()

        signinbtn.setOnClickListener {
            //sing in button intrent
            startActivity(Intent(this, Registration_form::class.java))
            finish()
        }
        forget.setOnClickListener {
            val builder= AlertDialog.Builder(this)
            val title = builder.setTitle("forget pasword")

        }
        loginbtn.setOnClickListener {
            var email = emailId.text.toString()
            var pass = password.text.toString()
            if (email.isBlank()) {
                emailId.error = "Enter Your Email"
            } else if (pass.isBlank()) {
                password.error = "Enter Your Password"
                if (pass.length < 6){
                    Toast.makeText(this, "password must be greater than 6 digits", Toast.LENGTH_SHORT).show()
                }
            } else {
                checkemailAndPassword(email, pass)
            }
        }
    }

    private fun checkemailAndPassword(email: String, pass: String) {
        firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this,
            OnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    //loggin Button intent
                    startActivity(Intent(this, HomePage::class.java))
//                    progressBar.isGone
                    finish()
                } else {
                    Toast.makeText(this, it.exception?.message ?: "", Toast.LENGTH_SHORT).show()
                }
            })

    }

}