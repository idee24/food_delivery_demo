package com.example.food_delivery_demo.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.mvrx.*
import com.example.food_delivery_demo.CheckoutViewModel
import com.example.food_delivery_demo.MenuViewModel
import com.example.food_delivery_demo.R
import com.example.food_delivery_demo.adapters.MenuAdapter
import com.example.food_delivery_demo.networking.MenuData
import com.example.food_delivery_demo.networking.MenuItem
import com.example.food_delivery_demo.networking.PaymentItem
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_food_list.*

/**
 *Created by Yerimah on 12/18/2020.
 */

class MenuListFragment(private val menuData: MenuData, private val categoryId: Int) : Fragment(R.layout.fragment_food_list) {

    private val viewModel: CheckoutViewModel by activityViewModels()
    private val compositeDisposable =  CompositeDisposable()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        menuData.filters?.forEach { deployFilter(it.filterName ?: "") }

        val displayItems = ArrayList<MenuItem>()
        menuData.menuItems?.forEach {
            if (it.categoryId == categoryId) {
                displayItems.add(it)
            }
        }
        initRecyclerView(displayItems)

        compositeDisposable.add((menuRecyclerView.adapter as MenuAdapter).getObservableProductItem().subscribe {
            viewModel.addToCart(it)
            (parentFragment as HomeFragment).parentFab.increase()
        })
    }

    private fun deployFilter(filterName: String) {

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

    private fun initRecyclerView(displayItems: ArrayList<MenuItem>) {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = RecyclerView.VERTICAL
        menuRecyclerView.layoutManager = layoutManager
        menuRecyclerView.adapter = MenuAdapter(displayItems)
    }


    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

}