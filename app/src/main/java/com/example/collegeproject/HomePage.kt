package com.example.collegeproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

private lateinit var firebaseAuth: FirebaseAuth
class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        var name: TextView = findViewById(R.id.txtname)
        var Rollnumber: TextView = findViewById(R.id.txtrollno)
        var classname: TextView = findViewById(R.id.txtclass)
        val logout: Button = findViewById(R.id.btnLogout)
        val bundle = intent.extras
        firebaseAuth = FirebaseAuth.getInstance()

        logout.setOnClickListener {
            Toast.makeText(this, "Logged-Out", Toast.LENGTH_SHORT).show()
            firebaseAuth.signOut()
            startActivity(Intent(this,frontapp::class.java))
            finish()
        }

        if (bundle != null) {
            name.text = bundle.getString("name").toString()
            Rollnumber.text = bundle.getString("class").toString()
            classname.text = bundle.getString("rollno").toString()
        }
    }
}