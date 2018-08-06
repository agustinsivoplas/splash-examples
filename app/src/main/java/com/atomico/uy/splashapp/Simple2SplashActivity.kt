package com.atomico.uy.splashapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import kotlinx.android.synthetic.main.activity_simple_2.*

class Simple2SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_2)

        logoImageView.postDelayed({
            val animationScaleUp = ScaleAnimation(1f, 1.2f, 1f, 1.2f, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f)
            animationScaleUp.duration = 300
            animationScaleUp.fillAfter = true

            animationScaleUp.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationRepeat(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    playScaleDown()
                }
                override fun onAnimationStart(animation: Animation?) {
                }
            })

            logoImageView.startAnimation(animationScaleUp)
        }, 500)
    }

    private fun playScaleDown() {
        val animationScaleDown = ScaleAnimation(1f, 0f, 1f, 0f, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f)
        animationScaleDown.duration = 200
        animationScaleDown.fillAfter = true

        animationScaleDown.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                welcomeMessageTextView.visibility = View.VISIBLE
                val animation = AlphaAnimation(0.0f, 1.0f)
                animation.duration = 500
                animation.fillAfter = true
                welcomeMessageTextView.startAnimation(animation)
            }
            override fun onAnimationStart(animation: Animation?) {
            }
        })

        logoImageView.startAnimation(animationScaleDown)
    }
}
