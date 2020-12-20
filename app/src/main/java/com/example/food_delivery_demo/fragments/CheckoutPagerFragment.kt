package com.example.food_delivery_demo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.food_delivery_demo.R
import com.example.food_delivery_demo.adapters.CheckoutAdapter
import kotlinx.android.synthetic.main.fragment_checkout_pager.*

/**
 *Created by Yerimah on 12/20/2020.
 */
class CheckoutPagerFragment : Fragment(R.layout.fragment_checkout_pager) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
    }

    fun initRecyclerView() {

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = RecyclerView.VERTICAL
        checkoutRecyclerView.layoutManager = layoutManager
        checkoutRecyclerView.adapter = CheckoutAdapter()
    }
}