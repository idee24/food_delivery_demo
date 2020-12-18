package com.example.food_delivery_demo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.food_delivery_demo.Constants
import com.example.food_delivery_demo.R
import com.example.food_delivery_demo.adapters.MenuPagerAdapter
import com.example.food_delivery_demo.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.content_scrolling.*
import kotlinx.android.synthetic.main.fragment_home.*
import me.relex.circleindicator.CircleIndicator
import java.util.*

/**
 *Created by Yerimah on 12/18/2020.
 */
class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initHeaderViewPager(headerViewPager, childFragmentManager, pagerIndicator)
        initMenuViewPager()
    }

    private fun initHeaderViewPager(viewPager: ViewPager,
                                    childFragmentManager: FragmentManager,
                                    indicator: CircleIndicator) {


        val displayList = LinkedList<Fragment>()

        val bundle = Bundle().apply { putInt(Constants.HEADER_IMAGE_KEY, R.drawable.t) }
        val pagerFragment = HeaderFragment()
        pagerFragment.arguments = bundle
        displayList.add(pagerFragment)

        val bundl = Bundle().apply { putInt(Constants.HEADER_IMAGE_KEY, R.drawable.t) }
        val pagerFragmen = HeaderFragment()
        pagerFragment.arguments = bundl
        displayList.add(pagerFragmen)

        val bund = Bundle().apply { putInt(Constants.HEADER_IMAGE_KEY, R.drawable.t) }
        val pagerFragme = HeaderFragment()
        pagerFragment.arguments = bund
        displayList.add(pagerFragme)

        val pagerAdapter = ViewPagerAdapter(childFragmentManager, displayList)
        viewPager.adapter = pagerAdapter
        indicator.setViewPager(viewPager)
        pagerAdapter.registerDataSetObserver(indicator.dataSetObserver)
    }

    private fun initMenuViewPager() {

        val pagerAdapter = MenuPagerAdapter(childFragmentManager)
        pagerAdapter.addFragment(MenuListFragment(), "Sushi")
        pagerAdapter.addFragment(MenuListFragment(), "Drinks")
        pagerAdapter.addFragment(MenuListFragment(), "Pizza")

        menuViewPager.adapter = pagerAdapter
        menuTabs.setupWithViewPager(menuViewPager)
    }

}