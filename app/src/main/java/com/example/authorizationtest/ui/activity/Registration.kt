package com.example.authorizationtest.ui.activity

import AuthViewModel
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.authorizationtest.MainActivity
import com.example.authorizationtest.R

class Registration : AppCompatActivity() {
    private val authViewModel: AuthViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val phoneEditText = findViewById<EditText>(R.id.phoneEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val backButton = findViewById<Button>(R.id.backButton)
        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            authViewModel.signUp(email, password) { response ->
                if (response?.user != null) {
                    Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Registration failed!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        backButton.setOnClickListener {
            finish()
        }
    }
}
