package com.atomico.uy.splashapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AlphaAnimation
import kotlinx.android.synthetic.main.activity_simple.*

class SimpleSplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 1500
        animation.fillAfter = true
        logoImageView.startAnimation(animation)
    }
}
