package com.example.collegeproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.collegeproject.databinding.ActivityRegistrationFormBinding

class StudentDetails : AppCompatActivity() {
    private lateinit var  binding: ActivityRegistrationFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)
        val getname: EditText = findViewById(R.id.getName)
        val getclass: EditText = findViewById(R.id.getClass)
        val getroll: EditText = findViewById(R.id.getrollnumber)
        val getcontact: EditText = findViewById(R.id.getContact)
        val submitbtn: Button = findViewById(R.id.submitbtn)
        var ProgressBar: ProgressBar = findViewById(R.id.progress_circularr)

        submitbtn.setOnClickListener {
            var name = getname.text.toString()
            var getclass = getclass.text.toString()
            var rollnumber = getroll.text.toString()

            var bundle = bundleOf()
            bundle.putString("name", name)
            bundle.putString("class", getclass)
            bundle.putString("rollno", rollnumber)
            val intent = Intent(this, HomePage::class.java)
            intent.putExtras(bundle)
            Toast.makeText(this, "Details Submitted Successfully", Toast.LENGTH_SHORT).show()
            ProgressBar.isVisible

            Handler(Looper.myLooper()!!).postDelayed(Runnable {
                startActivity(intent)
                ProgressBar.isInvisible
            }, 3000)
        }
    }
}