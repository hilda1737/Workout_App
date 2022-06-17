package com.getfit.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.getfit.workoutlog.databinding.ActivityLoginBinding
import com.getfit.workoutlog.databinding.ActivitySighnupBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class SighnupActivity : AppCompatActivity() {
   lateinit var binding: ActivitySighnupBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sighnup)


        binding.tvLogin.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            startActivity((intent))
        }
        binding.btnSignUp.setOnClickListener {
            validateSignUp()
        }

    }


fun validateSignUp() {
    var error = false
    binding.tilpassword.error = null
    binding.tilFirstname.error = null
    binding.tilSecond.error = null
    binding.tilConfirm.error = null
    var email = binding.etEmail3.text.toString()
    if (email.isBlank()) {
        binding.tilEmail3.error = "Error is required "
        error = true


    }


    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        binding.tilEmail3.error = "Not valid Email"
        error = true


    }


         var first=binding.etFirstname.text.toString()
        if (first.isBlank()) {
            binding.tilFirstname.error = "First name is required"
            error = true
        }
         var second=binding.etSecond.text.toString()
        if (second.isBlank()) {
            binding.tilSecond.error = "Last name is required"
            error = true
        }

         var password=binding.etMypassword.text.toString()
        if (password.isBlank()) {
            binding.tilpassword.error = "Password is required"
            error = true

        }
         var confirm=binding.etConfirm.text.toString()
        if (confirm.isBlank()) {
            binding.tilConfirm.error = "Confirm Password"
            error = true

        }
      if (!error){

    }
    if(password!=confirm)
        binding.tilConfirm.error="password error!"
}
}

