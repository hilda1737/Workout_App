package com.getfit.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var etemail: TextInputEditText
    lateinit var btnlogin: Button
    lateinit var etpassword: TextInputEditText
    lateinit var tvsighnup: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnlogin = findViewById(R.id.btnlogin)
        etemail = findViewById(R.id.etemail)
        tvsighnup = findViewById(R.id.tvsighnup)
        etpassword = findViewById(R.id.etpassword)
        btnlogin.setOnClickListener { validatelogin() }
    }

    fun validatelogin() {
        var error = false
        etemail.error=null
        etpassword.error=null
        var email = etemail.text.toString()
        if (email.isBlank()) {
            etemail.error = "Error is required "
            error=true

        }

        var password = etpassword.text.toString()
        if(password.isBlank()){
            etpassword.error="password is required"
            error=true
        }
        if (!error){

        }
    }

}