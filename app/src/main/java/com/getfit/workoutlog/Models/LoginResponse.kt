package com.getfit.workoutlog.Models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    var message:String,
    @SerializedName("acces_token") var accestoken: String,
    @SerializedName("uer_Id") var   userId:String,
    @SerializedName("profile_Id") var profileId:String,
)
