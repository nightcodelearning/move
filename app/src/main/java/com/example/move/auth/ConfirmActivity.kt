package com.example.move.auth

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.move.R
import com.example.move.databinding.ActivityConfirmBinding

class ConfirmActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityConfirmBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)
        setContentView(binding.root)

        binding.btnVerify.setOnClickListener{
            val intent = intent
            val username: String? = intent.getStringExtra("username")
            val code: String = binding.etCode.text.toString()
            val amplifyCognito = AmplifyCognito(this)
            amplifyCognito.confirm(username,code)

        }




    }
}