package com.getfit.workoutlog.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.getfit.workoutlog.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
  lateinit var binding:ActivityLoginBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.tvSignUp.setOnClickListener {
            val intent=Intent(this, SighnupActivity::class.java)
            startActivity(intent)
        }
        binding.btnlogin.setOnClickListener {
            validatelogin()
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }


    fun validatelogin() {
        var error = false
        binding.tilEmail.error = null
        binding.tilPassword.error = null
        var email = binding.etEmail.text.toString()
        if (email.isBlank()) {
            binding.tilEmail.error = "Error is required "
            error = true


        }

            var password = binding.etPassword.text.toString()
            if(password.isBlank()){

                binding.tilPassword.error="Password is required"
                error=true
            }
        if(!error){
            startActivity(Intent(this, HomeActivity::class.java))

        }
    }
}
