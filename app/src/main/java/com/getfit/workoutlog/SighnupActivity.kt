package com.getfit.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SighnupActivity : AppCompatActivity() {
    lateinit var etEmail3: TextInputEditText
    lateinit var tilEmail3: TextInputLayout
    lateinit var btnSignUp: Button
    lateinit var etpassword: TextInputEditText
    lateinit var tvsighnup: TextView
    lateinit var etFirstname: TextInputEditText
    lateinit var etSecondname: TextInputEditText
    lateinit var tilFirstname: TextInputLayout
    lateinit var tilsecondname: TextInputLayout
    lateinit var tilpassword: TextInputLayout
    lateinit var tilConfirm: TextInputLayout
    lateinit var etConfirm: TextInputEditText
    lateinit var tvLogin:TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sighnup)
        btnSignUp= findViewById(R.id.btnSignUp)
        etEmail3 = findViewById(R.id.etEmail3)
        etpassword = findViewById(R.id.etpassword)
        tilFirstname = findViewById(R.id.tilFirstname)
        tilpassword=findViewById(R.id.tilPassword)
        tilsecondname = findViewById(R.id.tilsecondname)
        tilConfirm = findViewById(R.id.tilpassword)
        etConfirm = findViewById(R.id.etConfirm)
        etpassword = findViewById(R.id.etPassword)
        etSecondname = findViewById(R.id.etSecondname)
        etFirstname=findViewById(R.id.etFirstname)
        tilEmail3=findViewById(R.id.tilEmail3)
        tvLogin=findViewById(R.id.tvLogin)
        tvsighnup=findViewById(R.id.tvsighnup)

        tvLogin.setOnClickListener {
            var intent=Intent(this,LoginActivity::class.java)
            startActivity((intent))
        }
        btnSignUp.setOnClickListener {
            validateSignUp()
        }
    }


fun validateSignUp() {
    var error = false
    etEmail3.error = null
    etpassword.error = null
    etFirstname.error=null
    etSecondname.error=null
    etConfirm.error=null
    var email = etEmail3.text.toString()
    if (email.isBlank()) {
        tilEmail3.error = "Error is required "
        error = true


    }
         var first=etFirstname.text.toString()
        if (first.isBlank()) {
            tilFirstname.error = "First name is required"
            error = true
        }
         var second=etSecondname.text.toString()
        if (second.isBlank()) {
            tilsecondname.error = "Last name is required"
            error = true
        }

         var password=etpassword.text.toString()

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
}
}

