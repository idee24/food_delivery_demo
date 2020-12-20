package com.example.food_delivery_demo.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
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

        deployFilter("Vegan")
        deployFilter("Low-Carb Diet")
    }

    fun deployFilter(filterName: String) {

        val layoutInflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = layoutInflater.inflate(R.layout.filter_view, null)
        val filterTextView: TextView = itemView.findViewById(R.id.filterTextView)
        filterTextView.text = filterName

        itemView.setOnClickListener {
            itemView.setBackgroundResource(R.drawable.filter_selected)
            filterTextView.setTextColor(Color.WHITE)
        }
        filterLayout.addView(itemView)
    }


    fun initRecyclerView() {

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = RecyclerView.VERTICAL
        menuRecyclerView.layoutManager = layoutManager
        menuRecyclerView.adapter = MenuAdapter()
    }
}