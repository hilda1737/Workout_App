package com.getfit.workoutlog.UI

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    lateinit var  sharedpref:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedpref=getSharedPreferences("WORKOUT_PREFS", MODE_PRIVATE)
        val acceToken=sharedpref.getString("ACCESS_TOKEN","")
        if (acceToken!!.isBlank()){
            startActivity(Intent(this, LoginActivity::class.java))

        }else{
        startActivity(Intent(this, HomeActivity::class.java))
        }

    }
}