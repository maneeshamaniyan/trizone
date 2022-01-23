package com.example.trizone.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.trizone.R

/*Created by Maneesha on 18/12/2021*/

class NSSplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        val text: TextView = findViewById(R.id.tileText)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide)
        text.startAnimation(slideAnimation)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, NSMainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }


}