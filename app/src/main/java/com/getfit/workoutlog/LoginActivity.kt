package com.getfit.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var etEmail: TextInputEditText
    lateinit var tilEmail: TextInputLayout
    lateinit var btnlogin: Button
    lateinit var etPassword: TextInputEditText
    lateinit var tvsighnup: TextView
    lateinit var tilPassword: TextInputLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnlogin = findViewById(R.id.btnlogin)
       etEmail = findViewById(R.id.etEmail)
        tvsighnup = findViewById(R.id.tvsighnup)
        etPassword = findViewById(R.id.etPassword)
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword)

        tvsighnup.setOnClickListener {
            val intent=Intent(this,SighnupActivity::class.java)
            startActivity(intent)

        }

        btnlogin.setOnClickListener {
            validatelogin()
        }
    }


    fun validatelogin() {
        var error = false
        tilEmail.error = null
        tilPassword.error = null
        var email = etEmail.text.toString()
        if (email.isBlank()) {
            tilEmail.error = "Error is required "
            error = true


        }

            var password = etPassword.text.toString()
            if(password.isBlank()){
                tilPassword.error="Password is required"
                error=true
            }
        if(!error){

        }
    }
}
