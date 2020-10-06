package com.example.catatanbelanja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.catatanbelanja.ui.shoppinglist.ShoppingActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        lateinit var fadeIn: Animation

        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val appLogo = findViewById<ImageView>(R.id.imageView)
        appLogo.startAnimation(fadeIn)
        Handler().postDelayed({

                startActivity(Intent(this, ShoppingActivity::class.java))
                finish()

        }, 2000)
    }
}