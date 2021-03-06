package com.example.food_delivery_demo.fragments

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.food_delivery_demo.CheckoutViewModel
import com.example.food_delivery_demo.R
import com.example.food_delivery_demo.adapters.MenuPagerAdapter
import com.example.food_delivery_demo.networking.MenuItem
import kotlinx.android.synthetic.main.fragment_checkout.*

/**
 *Created by Yerimah on 12/18/2020.
 */
class CheckoutFragment : Fragment(R.layout.fragment_checkout) {

    private val viewModel: CheckoutViewModel by activityViewModels()
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initMenuViewPager(viewModel.getCartItems())
        backIcon.setOnClickListener { findNavController().popBackStack() }
        fab.setOnClickListener {
            Toast.makeText(context, "PAID", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initMenuViewPager(checkoutItems: List<MenuItem>) {

        val pagerAdapter = MenuPagerAdapter(childFragmentManager)
        pagerAdapter.addFragment(CheckoutPagerFragment(checkoutItems), "Cart")
        pagerAdapter.addFragment(CheckoutPagerFragment(checkoutItems), "Orders")
        pagerAdapter.addFragment(CheckoutPagerFragment(checkoutItems), "Information")

        checkoutPager.adapter = pagerAdapter
        checkoutTabs.setupWithViewPager(checkoutPager)
    }
}