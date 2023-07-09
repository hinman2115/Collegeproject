
package com.example.collegeproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.collegeproject.databinding.ActivityRegistrationFormBinding
import com.google.firebase.auth.FirebaseAuth



class Registration_form : AppCompatActivity() {

    private lateinit var binding:ActivityRegistrationFormBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityRegistrationFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        val username: EditText = findViewById(R.id.username)
        val rollno: EditText = findViewById(R.id.RollNo)
        val password: EditText = findViewById(R.id.password)
        val register: Button = findViewById(R.id.btnRegister)
        val loginbtn: TextView = findViewById(R.id.logintext)

        loginbtn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        register.setOnClickListener {
            var email = username.text.toString()
            var rollno = username.text.toString()
            var pass = username.text.toString()

            if (email.isBlank()){
                Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show()
            }
            else if (pass.length !=6){
                Toast.makeText(this, "Enter password greater than 6 digit", Toast.LENGTH_SHORT).show()
                firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intent = Intent(this,HomePage::class.java)
                        startActivity(intent)
                    }
                }
            }
            else{
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,HomePage::class.java))
                finish()
            }

        }

    }
}