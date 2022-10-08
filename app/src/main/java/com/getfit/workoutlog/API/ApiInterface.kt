package com.getfit.workoutlog.API

import com.getfit.workoutlog.Models.RegisterRequest
import com.getfit.workoutlog.Models.LoginResponse
import com.getfit.workoutlog.Models.Loginrequest
import com.getfit.workoutlog.Models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
     fun registerUser(@Body registerRequest: RegisterRequest): Call<RegisterResponse>

    @POST("/Login")
    suspend fun LoginUser(@Body loginRequest:Loginrequest): Response<LoginResponse>
}
