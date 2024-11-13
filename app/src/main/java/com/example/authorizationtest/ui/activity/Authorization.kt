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

class Authorization : AppCompatActivity() {
        private val authViewModel: AuthViewModel by viewModels()
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_authorization)
            val emailEditText = findViewById<EditText>(R.id.emailEditText)
            val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
            val signInButton = findViewById<Button>(R.id.signInButton)
            val signUpButton = findViewById<Button>(R.id.signUpButton)
            signInButton.setOnClickListener {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                authViewModel.signIn(email, password) { response ->
                    if (response?.user != null) {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "Sign in failed!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            signUpButton.setOnClickListener {
                startActivity(Intent(this, Registration::class.java))
            }
        }
    }
