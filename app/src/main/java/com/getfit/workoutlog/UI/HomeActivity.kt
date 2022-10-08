package com.getfit.workoutlog.UI

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentContainerView
import com.getfit.workoutlog.R
import com.getfit.workoutlog.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var bnv: BottomNavigationView
    lateinit var fcvHome: FragmentContainerView
    lateinit var binding: ActivityHomeBinding
    lateinit var sharePrefs: SharedPreferences
    lateinit var tvLogout: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_home)


        tvLogout = findViewById(R.id.tvLogout)
        tvLogout.setOnClickListener {
            val editor = sharePrefs.edit()
            editor.putString("ACCESS_TOKEN", "")
            editor.putString("USER_ID", "")
            editor.putString("PROFILE_ID", "")
            editor.apply()
            startActivity(Intent(this, LoginActivity::class.java))
            logoutrequest()


        }
        castview()
        setup()


    }

    fun castview() {
        bnv = findViewById(R.id.bnv)
        fcvHome = findViewById(R.id.fcvHome)
    }

    fun setup() {
        bnv.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.plan -> {
                    var transaction = supportFragmentManager.beginTransaction()
                        .replace(R.id.fcvHome, PlanFragment()).commit()
                    true

                }
                R.id.track -> {
                    var transaction = supportFragmentManager.beginTransaction()
                        .replace(R.id.fcvHome, TrackFragment()).commit()
                    true


                }
                R.id.profile -> {
                    var transaction = supportFragmentManager.beginTransaction().replace(
                        R.id.fcvHome,
                        ProfileFragment()
                    ).commit()
                    true
                }
                else -> false
            }
        }

    }

    fun logoutrequest() {
        sharePrefs.edit().clear().commit()
    }
}