package com.example.move.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.move.R
import com.example.move.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivitySignInBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        setContentView(binding.root)
        val amplifyCognito = AmplifyCognito(this)

        binding.btnLogin.setOnClickListener{
            val strUserName: String = binding.etUsername.text.toString()
            val strPassword: String = binding.etPassword.text.toString()
            amplifyCognito.signIn(strUserName,strPassword)

        }

        binding.btnSignup.setOnClickListener {
            amplifyCognito.loadSignUp()
        }





    }
}