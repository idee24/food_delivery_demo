package com.example.food_delivery_demo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.food_delivery_demo.MenuItem
import com.example.food_delivery_demo.R
import com.example.food_delivery_demo.adapters.MenuAdapter
import kotlinx.android.synthetic.main.fragment_food_list.*

/**
 *Created by Yerimah on 12/18/2020.
 */
class MenuListFragment : Fragment(R.layout.fragment_food_list) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
    }

    fun initRecyclerView() {

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = RecyclerView.VERTICAL
        menuRecyclerView.layoutManager = layoutManager
        menuRecyclerView.adapter = MenuAdapter()
    }
}