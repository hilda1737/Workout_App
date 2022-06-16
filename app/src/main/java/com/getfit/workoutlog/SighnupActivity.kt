package com.getfit.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class SighnupActivity : AppCompatActivity() {
    lateinit var etEmail3: TextInputEditText
    lateinit var tilEmail3: TextInputLayout
    lateinit var btnSignUp: Button
    lateinit var etMypassword: TextInputEditText

    lateinit var etFirstname: TextInputEditText
    lateinit var etSecond: TextInputEditText
    lateinit var tilFirstname: TextInputLayout
    lateinit var tilSecond: TextInputLayout
    lateinit var tilpassword: TextInputLayout
    lateinit var tilConfirm: TextInputLayout
    lateinit var etConfirm: TextInputEditText
    lateinit var tvLogin:TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sighnup)
        btnSignUp= findViewById(R.id.btnSignUp)
        etEmail3 = findViewById(R.id.etEmail3)
        etMypassword = findViewById(R.id.etMypassword)
        tilFirstname = findViewById(R.id.tilFirstname)
        tilpassword=findViewById(R.id.tilpassword)
        tilSecond = findViewById(R.id.tilSecond)
        tilConfirm = findViewById(R.id.tilConfirm)
        etConfirm = findViewById(R.id.etConfirm)

        etSecond= findViewById(R.id.etSecond)
        etFirstname=findViewById(R.id.etFirstname)
        tilEmail3=findViewById(R.id.tilEmail3)
        tvLogin=findViewById(R.id.tvLogin)


        tvLogin.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            startActivity((intent))
        }
        btnSignUp.setOnClickListener {
            validateSignUp()
        }

    }


fun validateSignUp() {
    var error = false
    tilEmail3.error = null
    tilpassword.error = null
    tilFirstname.error = null
    tilSecond.error = null
    tilConfirm.error = null
    var email = etEmail3.text.toString()
    if (email.isBlank()) {
        tilEmail3.error = "Error is required "
        error = true


    }


    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        tilEmail3.error = "Not valid Email"
        error = true


    }


         var first=etFirstname.text.toString()
        if (first.isBlank()) {
            tilFirstname.error = "First name is required"
            error = true
        }
         var second=etSecond.text.toString()
        if (second.isBlank()) {
            tilSecond.error = "Last name is required"
            error = true
        }

         var password=etMypassword.text.toString()
        if (password.isBlank()) {
            tilpassword.error = "Password is required"
            error = true

        }
         var confirm=etConfirm.text.toString()
        if (confirm.isBlank()) {
            tilConfirm.error = "Confirm Password"
            error = true

        }
      if (!error){

    }
    if(password!=confirm)
        tilConfirm.error="password error!"
}
}

