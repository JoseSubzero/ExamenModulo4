package com.example.examenmodulo4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examenmodulo4.SharedPreferences.Companion.prefs
import com.example.examenmodulo4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        CheckUserValues()

    }

    private fun initUI() {
        binding.btnLogin.setOnClickListener {
            accessSharedPreferences()
        }
    }

    private fun CheckUserValues() {
        if (prefs.getName().isNotEmpty() &&
                prefs.getPassword().isNotEmpty()) {
            goAccess()
        }
    }

    fun accessSharedPreferences() {
        if (binding.etUserName.text.toString().isNotEmpty() &&
            binding.etPassword.text.toString().isNotEmpty()
        ) {
            prefs.saveUserName(binding.etUserName.text.toString())
            prefs.savePassword(binding.etPassword.text.toString())
            goAccess()
        } else {
            Toast.makeText(this, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
    private fun goAccess(){
        startActivity(Intent(this, WelcomeActivity::class.java))
    }
}