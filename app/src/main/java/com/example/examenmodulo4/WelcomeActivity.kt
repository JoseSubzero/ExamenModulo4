package com.example.examenmodulo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examenmodulo4.SharedPreferences.Companion.prefs
import com.example.examenmodulo4.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    fun initUI(){
        binding.btnEndSession.setOnClickListener {
            prefs.wipeData()
            onBackPressed()
        }

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

    }
}