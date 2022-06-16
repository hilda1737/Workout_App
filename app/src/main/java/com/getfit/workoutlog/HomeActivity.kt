package com.getfit.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var bnv: BottomNavigationView
    lateinit var fcvHome: FragmentContainerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
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
                    var transaction = supportFragmentManager.beginTransaction().replace(R.id.fcvHome, PlanFragment()).commit()
                    true

                }
                R.id.track -> {
                    var transaction = supportFragmentManager.beginTransaction().replace(R.id.fcvHome, TrackFragment()).commit()
                    true


                }
                R.id.profile -> {
                    var transaction = supportFragmentManager.beginTransaction().replace(R.id.fcvHome,ProfileFragment()).commit()
                    true
                }
                else->false
            }
        }
    }
}