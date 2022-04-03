package com.veen.cars.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.veen.cars.R

class ImageSliderAdapter(private val context: Context) : PagerAdapter() {
    private var inflater: LayoutInflater? = null
    private val images =
        arrayOf(R.drawable.slider1, R.drawable.slider2, R.drawable.slider3, R.drawable.slider4)

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater!!.inflate(R.layout.image_slider, null)
        view.findViewById<ImageView>(R.id.slider_image).setImageResource(images[position])
/*        Picasso.get()
            .load("https://www.google.com/url?sa=i&url=https%3A%2F%2Fphotographycourse.net%2F5-steps-to-amazing-landscape-photography%2F&psig=AOvVaw256DIXBSd4qsfFNSMW3yZt&ust=1645937610871000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKi1rMfJnPYCFQAAAAAdAAAAABAD")
            .into(view.findViewById<ImageView>(R.id.slider_image))*/

        val vp = container as ViewPager
        vp.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }
}