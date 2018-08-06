package com.atomico.uy.splashapp

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import android.view.View
import android.view.animation.AlphaAnimation
import kotlinx.android.synthetic.main.activity_facebook_start_layout.*

class FacebookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facebook_start_layout)

        root.postDelayed({
            val constraint1 = ConstraintSet()
            constraint1.clone(root)
            val constraint2 = ConstraintSet()
            constraint2.clone(this@FacebookActivity, R.layout.activity_facebook_start_layout_2)
            constraint2.applyTo(root)
            TransitionManager.beginDelayedTransition(root)

            val animation = AlphaAnimation(0.0f, 1.0f)
            animation.duration = 500
            fbBgImageView.visibility = View.VISIBLE
            fbBgImageView.startAnimation(animation)

            val animationLong = AlphaAnimation(0.0f, 1.0f)
            animationLong.duration = 1500
            loginButton.startAnimation(animationLong)
            createAccountButton.startAnimation(animationLong)

        }, 1000)
    }
}
