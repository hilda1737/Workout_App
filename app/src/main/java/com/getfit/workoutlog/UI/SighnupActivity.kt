package com.getfit.workoutlog.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.widget.Toast
import com.getfit.workoutlog.API.APIclient
import com.getfit.workoutlog.API.ApiInterface
import com.getfit.workoutlog.Models.RegisterRequest
import com.getfit.workoutlog.Models.RegisterResponse
import com.getfit.workoutlog.R
import com.getfit.workoutlog.databinding.ActivitySighnupBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SighnupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySighnupBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySighnupBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity((intent))
            validateSignUp()
        }
        binding.btnSignUp.setOnClickListener {
            validateSignUp()
        }

    }


    fun validateSignUp() {
        binding.etFirstname.error = null
        binding.etSecond.error = null
        binding.etMypassword.error = null
        binding.etEmail3.error = null
        binding.etConfirm.error = null
        binding.etEmail3.error = null
        var error = false


        var first = binding.etFirstname.text.toString()
        if (first.isBlank()) {
            binding.tilFirstname.error = "First name is required"
            error = true
        }
        var second = binding.etSecond.text.toString()
        if (second.isBlank()) {
            binding.tilSecond.error = "Last name is required"
            error = true
        }
        var email1 = binding.etEmail3.text.toString()
        if (email1.isBlank()) {
            binding.tilEmail3.error = "Password is required"
            error = true


        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
            binding.tilEmail3.error = "Not valid Email"
            error = true


        }
            var password = binding.etMypassword.text.toString()
            if (password.isBlank()) {
                binding.tilpassword.error = "Password is required"
                error = true


            }
        var number = binding.etPhonenumber.text.toString()
        if (number.isBlank()) {
            binding.tilPhonenumber.error = "Password is required"
            error = true
        }

        var confirm = binding.etConfirm.text.toString()
        if (confirm.isBlank()) {
            binding.tilConfirm.error = "Confirm Password"
            error = true

        }

        if (password != confirm) {
            binding.tilConfirm.error = "password error!"
        }
        if (!error) {
            val registerRequest = RegisterRequest(first, second, number, email1, password)
            makeRegeister(registerRequest)


        }
    }

    fun makeRegeister(registerRequest: RegisterRequest){
        var  apiClient= APIclient.ApiClient.buildApiClient(ApiInterface::class.java)
        val request= apiClient.registerUser(registerRequest)

        request.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>, response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful){
                    Toast.makeText(baseContext,response.body()?.message, Toast.LENGTH_LONG).show()

                }
                else {
                    val error=response.errorBody()?.string()
                    Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast .makeText(baseContext,t.message, Toast.LENGTH_LONG).show()
            }

        })
    }

}






