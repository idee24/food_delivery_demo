package com.example.food_delivery_demo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.airbnb.mvrx.*
import com.andremion.counterfab.CounterFab
import com.example.food_delivery_demo.CheckoutViewModel
import com.example.food_delivery_demo.Constants
import com.example.food_delivery_demo.R
import com.example.food_delivery_demo.adapters.MenuPagerAdapter
import com.example.food_delivery_demo.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import me.relex.circleindicator.CircleIndicator
import com.example.food_delivery_demo.MenuViewModel
import com.example.food_delivery_demo.networking.MenuData
import com.google.gson.Gson

/**
 *Created by Yerimah on 12/18/2020.
 */

data class MenuState(val menu: MenuData = MenuData()) : MavericksState

class HomeFragment :  Fragment(R.layout.fragment_home), MavericksView {

    private val viewModel: MenuViewModel by fragmentViewModel()
    lateinit var parentFab: CounterFab

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initHeaderViewPager(headerViewPager, childFragmentManager, pagerIndicator)
        
        parentFab = checkoutFab
        checkoutFab.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_checkoutFragment)
        }
        viewModel.retrieveMenu()
    }

    private fun initHeaderViewPager(viewPager: ViewPager,
                                    childFragmentManager: FragmentManager,
                                    indicator: CircleIndicator) {

        val pagerAdapter = ViewPagerAdapter(childFragmentManager, viewModel.getDisplayList())
        viewPager.adapter = pagerAdapter
        indicator.setViewPager(viewPager)
        pagerAdapter.registerDataSetObserver(indicator.dataSetObserver)
    }

    private fun initMenuViewPager(menu: MenuData) {
        val pagerAdapter = MenuPagerAdapter(childFragmentManager)
        menu.categories?.forEach {
            pagerAdapter.addFragment(MenuListFragment(menu, it.categoryId ?: 0), it.categoryName ?: "")
        }
        menuViewPager.adapter = pagerAdapter
        menuTabs.setupWithViewPager(menuViewPager)
    }

    override fun invalidate() = withState(viewModel) { menuState ->
        initMenuViewPager(menuState.menu)

        val bundle = Bundle()
        bundle.putString(Constants.SAVED_INSTANCE_KEY, Gson().toJson(menuState.menu))
        onSaveInstanceState(bundle)
    }
}