package com.example.food_delivery_demo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.food_delivery_demo.R
import com.example.food_delivery_demo.adapters.MenuPagerAdapter
import kotlinx.android.synthetic.main.fragment_checkout.*

/**
 *Created by Yerimah on 12/18/2020.
 */
class CheckoutFragment : Fragment(R.layout.fragment_checkout) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initMenuViewPager()
    }

    private fun initMenuViewPager() {

        val pagerAdapter = MenuPagerAdapter(childFragmentManager)
        pagerAdapter.addFragment(CheckoutPagerFragment(), "Cart")
        pagerAdapter.addFragment(CheckoutPagerFragment(), "Orders")
        pagerAdapter.addFragment(CheckoutPagerFragment(), "Information")

        checkoutPager.adapter = pagerAdapter
        checkoutTabs.setupWithViewPager(checkoutPager)
    }
}