package com.example.move.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.example.move.databinding.ActivitySignUpBinding

inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> T
) = lazy(LazyThreadSafetyMode.NONE) {
    bindingInflater(layoutInflater)
}

class SignUpActivity : AppCompatActivity() {


    private val binding by viewBinding(ActivitySignUpBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val amplifyCognito = AmplifyCognito(this)

        binding.btnSignup.setOnClickListener{
            val strUserName: String = binding.etUsername.text.toString()
            val strEmail: String = binding.etEmail.text.toString()
            val strPassword: String = binding.etPassword.text.toString()

            amplifyCognito.signUp(strEmail,strUserName,strPassword);
        }

        binding.btnSignIn.setOnClickListener{
            amplifyCognito.loadLogin();
        }


    }
}