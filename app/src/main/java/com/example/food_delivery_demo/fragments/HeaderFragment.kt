package com.example.food_delivery_demo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.food_delivery_demo.Constants
import com.example.food_delivery_demo.R
import kotlinx.android.synthetic.main.fragment_header.*


/**
 *Created by Yerimah on 12/18/2020.
 */
class HeaderFragment : Fragment(R.layout.fragment_header) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        displayImageView.setImageResource(R.drawable.banner_image)
    }
}