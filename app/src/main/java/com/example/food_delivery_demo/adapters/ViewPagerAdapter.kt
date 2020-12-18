package com.example.food_delivery_demo.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 *@Created by Yerimah on 6/6/2019.
 */
class ViewPagerAdapter(fm: FragmentManager,
                       private val displayList: List<Fragment>):
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return displayList[position]
    }

    override fun getCount(): Int {
        return displayList.size
    }
}