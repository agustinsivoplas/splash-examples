package com.atomico.uy.splashapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        uberButton.setOnClickListener {
            startActivity(Intent(this, UberActivity::class.java))
        }

        fbButton.setOnClickListener {
            startActivity(Intent(this, FacebookActivity::class.java))
        }

        simpleButton.setOnClickListener {
            startActivity(Intent(this, SimpleSplashActivity::class.java))
        }

        simple2Button.setOnClickListener {
            startActivity(Intent(this, Simple2SplashActivity::class.java))
        }

        simple3Button.setOnClickListener {
            startActivity(Intent(this, Simple3SplashActivity::class.java))
        }

        splash1Button.setOnClickListener {
            startActivity(Intent(this, Splash1Activity::class.java))
        }
    }
}
