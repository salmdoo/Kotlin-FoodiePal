package com.example.foodiepal.signup

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.foodiepal.R
import com.example.foodiepal.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var  binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener { clickRegister() }
    }

    fun clickRegister(){
        if (validateSignup()) {
            saveData()
        }
    }

    private fun saveData(){
        val sharePreference = getSharedPreferences("login", Context.MODE_PRIVATE)
        val shareEditMode = sharePreference.edit()

        shareEditMode.putString("username", binding.userName.text.toString())
        shareEditMode.putString("password", binding.password.text.toString())

        shareEditMode.apply()
        Toast.makeText(this, "Register successfully", Toast.LENGTH_LONG).show()
        finish()
    }

    private fun validateSignup(): Boolean {
        val pws = binding.confirmPassword.text.toString()
        val confirmPwd = binding.password.text.toString()
        if (pws.equals(confirmPwd)) {
            return  true
        }
        Toast.makeText(this, "Password doesn't match Confirm password", Toast.LENGTH_LONG).show()
        return false
    }
}