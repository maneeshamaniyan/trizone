package com.example.trizone.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.trizone.R
/*Created by Maneesha on 18/12/2021*/

class NSMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val signUpButton: Button = findViewById(R.id.signUpButton)
        val signInButton: Button = findViewById(R.id.signInButton)
        val skipButton: Button = findViewById(R.id.skipButton)
        signUpButton.setOnClickListener {
            val intent = Intent(this, NSSignUpActivity::class.java)
            startActivity(intent)
        }
        signInButton.setOnClickListener{
            val intent = Intent(this, NSSignInActivity::class.java)
            startActivity(intent)
        }
        skipButton.setOnClickListener{
            val intent = Intent(this, NSCategoryActivity::class.java)
            startActivity(intent)
        }

    }


}