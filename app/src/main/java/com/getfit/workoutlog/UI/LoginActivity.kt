package com.getfit.workoutlog.UI

import userRepository.Userviewmodel
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.getfit.workoutlog.Models.LoginResponse
import com.getfit.workoutlog.Models.Loginrequest
import com.getfit.workoutlog.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var shareprefs: SharedPreferences

    val userViewModel: Userviewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        shareprefs = getSharedPreferences("WORKOUT_PREFS", MODE_PRIVATE)

        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, SighnupActivity::class.java)
            startActivity(intent)
        }
        binding.btnlogin.setOnClickListener {
            validatelogin()
        }

    }

    override fun onResume() {
        super.onResume()
        userViewModel.registrationLiveData.observe(this, Observer { LogInResponse ->
            Toast.makeText(baseContext, LogInResponse?.message, Toast.LENGTH_LONG).show()
            savedLoginDetails(LogInResponse!!)
            startActivity(Intent(baseContext, HomeActivity::class.java))
        })
        userViewModel.errorlivedData.observe(this, Observer { errorMessage ->
            Toast.makeText(baseContext, errorMessage, Toast.LENGTH_LONG).show()
        })
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
        if (password.isBlank()) {

            binding.tilPassword.error = "Password is required"
            error = true
        }
        if (!error) {
            val loginrequest = Loginrequest(email, password)
            binding.progressBar4.visibility = View.GONE
//            makeLoginRequest(loginrequest)

        }

    }

    fun savedLoginDetails(LoginResponse: LoginResponse) {
        val editor = shareprefs.edit()
        editor.putString("ACCESS_TOKEN", LoginResponse.accestoken)
        editor.putString("USER_ID", LoginResponse.userId)
        editor.putString("PROFILE_ID", LoginResponse.profileId)
        editor.apply()
    }
}


