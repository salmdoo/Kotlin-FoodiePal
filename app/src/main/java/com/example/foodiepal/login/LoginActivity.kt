package com.example.foodiepal.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.foodiepal.R
import com.example.foodiepal.databinding.ActivityHomeBinding
import com.example.foodiepal.databinding.ActivityLoginBinding
import com.example.foodiepal.home.HomeActivity
import com.example.foodiepal.signup.SignupActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharePreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharePreferences = getSharedPreferences("login", Context.MODE_PRIVATE)
        loadLoginData()

        binding.loginBtn.setOnClickListener {
            clickLogin()
        }

        binding.signupBtn.setOnClickListener{
            clickSignUp()
        }
    }

    fun loadLoginData(){
        val username = sharePreferences.getString("username", "")
        val pwd = sharePreferences.getString("password", "")
        binding.username.setText(username)
        binding.password.setText(pwd)
    }

    fun clickLogin(){
        val username = sharePreferences.getString("username", "noVal")
        val pwd = sharePreferences.getString("password", "noVal")

        if (username.equals(binding.username.text.toString(), ignoreCase = true) &&
            pwd.equals(binding.password.text.toString(), ignoreCase = true)){

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Fail to login", Toast.LENGTH_LONG).show()
        }
    }

    fun clickSignUp(){
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }
}