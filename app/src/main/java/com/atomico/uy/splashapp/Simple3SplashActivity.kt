package com.atomico.uy.splashapp

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewAnimationUtils
import androidx.core.animation.doOnEnd
import kotlinx.android.synthetic.main.activity_simple_3.*

class Simple3SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_3)

        revealView.post {
            val cx = revealView.width / 2
            val cy = revealView.height / 2
            val finalRadius = Math.max(revealView.width, revealView.height)
            val anim = ViewAnimationUtils.createCircularReveal(revealView, cx, cy, finalRadius.toFloat(), 0f)

            anim.startDelay = 1000

            anim.doOnEnd {
                val alphaAnimation = ObjectAnimator
                        .ofFloat(logoImageView, View.ALPHA, 0f, 1f)
                        .setDuration(600)

                val circleAlphaAnimation = ObjectAnimator
                        .ofFloat(circleView, View.ALPHA, 0f, 1f)
                        .setDuration(400)

                val welcomeAlphaAnimation = ObjectAnimator
                        .ofFloat(welcomeMessageTextView, View.ALPHA, 0f, 1f)
                        .setDuration(800)

                val welcomeTranslationAnimator = ObjectAnimator
                        .ofFloat(welcomeMessageTextView, View.TRANSLATION_Y, 0f, -170f)
                        .setDuration(800)

                circleView.visibility = View.VISIBLE
                logoImageView.visibility = View.VISIBLE
                revealView.visibility = View.GONE

                var animationSet = AnimatorSet()
                animationSet.playSequentially(circleAlphaAnimation, alphaAnimation, welcomeAlphaAnimation, welcomeTranslationAnimator)
            }

            anim.start()
        }

    }

}
