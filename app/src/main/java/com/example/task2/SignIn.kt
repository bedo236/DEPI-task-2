package com.example.task2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.task2.databinding.ActivityMainBinding
import com.example.task2.databinding.ActivitySignInBinding

class SignIn : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignInBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.signInButton.setOnClickListener{
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()

            // Validate inputs
            if (username.isEmpty()) {
                Toast.makeText(this, "Username cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check password length and complexity
            if (password.length < 8 || !password.matches(".*[A-Za-z].*".toRegex()) || !password.matches(".*\\d.*".toRegex())) {
                Toast.makeText(this, "Password must be at least 8 characters, contain both letters and numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(Constants.USERNAME, username)
            intent.putExtra(Constants.PASSWORD, password)
            startActivity(intent)
            finish()
        }

    }
}