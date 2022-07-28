package com.example.move

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.move.auth.AmplifyCognito
import com.example.move.auth.viewBinding
import com.example.move.databinding.ActivityHomeBinding
import com.example.move.databinding.ActivitySignInBinding

class HomeActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityHomeBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setContentView(binding.root)

        val strUserName: String? = intent.getStringExtra("username")

        binding.tvUsername.text = "Welcome "+strUserName+"!";
        //LogOut
        binding.btnLogout.setOnClickListener{
            val amplifyCognito = AmplifyCognito(this)
            amplifyCognito.signOut()
        }
    }
}