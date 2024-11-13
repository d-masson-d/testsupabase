package com.example.authorizationtest

import AuthViewModel
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.authorizationtest.ui.activity.Authorization

class MainActivity : AppCompatActivity() {
    class MainActivity : AppCompatActivity() {
        private val authViewModel: AuthViewModel by viewModels()
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            if (authViewModel.getCurrentUser () == null) {
                startActivity(Intent(this, Authorization::class.java))
                finish()
            } else {
                setContentView(R.layout.activity_main)
            }
        }
    }

}