package com.veen.cars.utils

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class ViewPager2PageTransformation : ViewPager2.PageTransformer {
    val MIN_SCALE = 0.85f

    override fun transformPage(page: View, position: Float) {
        when {
            position < -1 ->
                page.alpha = 0.1f
            position <= 1 -> {
                page.alpha = Math.max(0.2f, 1 - Math.abs(position))
                val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
                page.scaleX = scaleFactor;
                page.scaleY = scaleFactor;

                val vertMargin = page.height * (1 - scaleFactor) / 2
                val horzMargin = page.width * (1 - scaleFactor) / 2
                page.translationX = if (position < 0) {
                    horzMargin - vertMargin / 2
                } else {
                    horzMargin + vertMargin / 2
                }

            }
            else -> page.alpha = 0.1f
        }
    }
}