package com.atomico.uy.splashapp

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewAnimationUtils
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart
import kotlinx.android.synthetic.main.activity_uber.*



class UberActivity : AppCompatActivity() {

    var handleBack = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uber)

        uberImageView.post {
            val cx = (uberImageView.left + uberImageView.right) / 2
            val cy = (uberImageView.top + uberImageView.bottom) / 2
            val finalRadius = Math.max(uberContainer.width, uberContainer.height)
            val anim = ViewAnimationUtils.createCircularReveal(revealView, cx, cy, 0f, finalRadius.toFloat())
            anim.startDelay = 1000

            anim.doOnStart {
                uberImageView.visibility = View.GONE
                revealView.visibility = View.VISIBLE
            }

            anim.doOnEnd {
                val alphaAnimation = ObjectAnimator
                        .ofFloat(uberTextImageView, View.ALPHA, 0f, 1f)
                        .setDuration(1000)

                uberTextImageView.visibility = View.VISIBLE
                alphaAnimation.start()

                handleBack = true
            }

            anim.start()
        }
    }

    override fun onBackPressed() {

        if (handleBack) {

            revealView.post {
                val cx = revealView.width / 2
                val cy = revealView.height / 2
                val finalRadius = Math.max(revealView.width, revealView.height)
                val anim = ViewAnimationUtils.createCircularReveal(revealView, cx, cy, finalRadius.toFloat(), 0f)

                anim.doOnStart {
                    uberTextImageView.visibility = View.GONE
                }

                anim.doOnEnd {
                    val alphaAnimation = ObjectAnimator
                            .ofFloat(uberImageView, View.ALPHA, 0f, 1f)
                            .setDuration(1000)

                    uberImageView.visibility = View.VISIBLE
                    alphaAnimation.start()

                    revealView.visibility = View.GONE
                    handleBack = false
                }

                anim.start()
            }

        } else {
            super.onBackPressed()
        }
    }
}
