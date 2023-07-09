package com.example.collegeproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.collegeproject.databinding.ActivityRegistrationFormBinding
import com.google.firebase.auth.FirebaseAuth

class Registration_form : AppCompatActivity() {


    private lateinit var binding: ActivityRegistrationFormBinding
    private lateinit var firebaseAuth: FirebaseAuth

    //    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+./+[a-z]+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var username: EditText = findViewById(R.id.username)
        var roll_no: EditText = findViewById(R.id.RollNo)
        var password: EditText = findViewById(R.id.password)
        val register: Button = findViewById(R.id.btnRegister)
        val loginbtn: TextView = findViewById(R.id.logintext)
        firebaseAuth = FirebaseAuth.getInstance()

        loginbtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        register.setOnClickListener {
            var email = username.text.toString()
            var rollno = roll_no.text.toString()
            var pass = password.text.toString()

            if (email.isBlank()) {
                username.setError("Email required")
            } else if (rollno.isBlank()) {
                roll_no.setError("RollNo. required")
            } else if (pass.isBlank()) {
                password.setError("Password required")
                if (pass.length < 6){
                    Toast.makeText(this, "password must be greater than 6 digits", Toast.LENGTH_SHORT).show()
                }
            } else {
                emailAuthentication(email, pass)
            }
        }
    }
    private fun emailAuthentication(email: String, pass: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomePage::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, it.exception?.message ?:"", Toast.LENGTH_SHORT).show()
            }
        }
    }
}