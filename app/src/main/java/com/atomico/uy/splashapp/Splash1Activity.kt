package com.atomico.uy.splashapp

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.core.animation.doOnEnd
import kotlinx.android.synthetic.main.activity_splash_1.*

class Splash1Activity : AppCompatActivity() {

    companion object {
        const val ANIMATION_DURATION: Long = 2500
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_1)
        displayLogoAnimation()
    }

    private fun displayLogoAnimation() {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(anim: Animation?) {
            }

            override fun onAnimationEnd(anim: Animation?) {
                    displayWelcomeAnimation()
            }

            override fun onAnimationStart(anim: Animation?) {
            }
        })
        animation.duration = ANIMATION_DURATION
        animation.fillAfter = true
        logoImageView.startAnimation(animation)
    }

    private fun displayWelcomeAnimation() {

        var animationSet = AnimatorSet()
        val logoTranslationAnimator = ObjectAnimator
                .ofFloat(logoImageView, View.TRANSLATION_Y, 0f, -130f)
                .setDuration(300)

        val welcomeAlphaAnimator = ObjectAnimator
                .ofFloat(welcomeTextView, View.ALPHA, 0f, 1f)
                .setDuration(600)

        val messageAlphaAnimator = ObjectAnimator
                .ofFloat(welcomeMessageTextView, View.ALPHA, 0f, 1f)
                .setDuration(600)

        val welcomeTranslationAnimator = ObjectAnimator
                .ofFloat(welcomeTextView, View.TRANSLATION_Y, 0f, -175f)
                .setDuration(300)

        val messageTranslationAnimator = ObjectAnimator
                .ofFloat(welcomeMessageTextView, View.TRANSLATION_Y, 0f, 5f)
                .setDuration(300)

        val learnMoreLayoutAlphaAnimator = ObjectAnimator
                .ofFloat(loginTextLayout, View.ALPHA, 0f, 1f)
                .setDuration(500)

        val learnMoreButtonAlphaAnimator = ObjectAnimator
                .ofFloat(createAccountButton, View.ALPHA, 0f, 1f)
                .setDuration(500)

        animationSet.play(logoTranslationAnimator)
        animationSet.play(welcomeAlphaAnimator).with(welcomeTranslationAnimator).after(100)
        animationSet.play(messageAlphaAnimator).with(messageTranslationAnimator).after(100)
        animationSet.play(learnMoreLayoutAlphaAnimator).with(learnMoreButtonAlphaAnimator).after(150)

        animationSet.doOnEnd {
            createAccountButton.isEnabled = true
            logInTextView.isEnabled = true
        }

        animationSet.start()
    }

}
