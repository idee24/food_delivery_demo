package com.example.food_delivery_demo.utils

import android.content.Context
import com.example.food_delivery_demo.R
import com.example.food_delivery_demo.networking.Category
import com.example.food_delivery_demo.networking.Filter
import com.example.food_delivery_demo.networking.MenuData
import com.example.food_delivery_demo.networking.MenuItem

/**
 *Created by Yerimah on 12/21/2020.
 */
fun generateMockData(context: Context): MenuData {

    val items = ArrayList<MenuItem>()
    items.add(MenuItem(0, 0, 3, context.getString(R.string.name_one),
        context.getString(R.string.dsc_one), 15.0, R.drawable.img_one, context.getString(R.string.details_one)))

    items.add(MenuItem(1, 0, 1, context.getString(R.string.name_two),
        context.getString(R.string.dsc_two), 15.0, R.drawable.img_two, context.getString(R.string.details_two)))

    items.add(MenuItem(0, 0, 1, context.getString(R.string.name_three),
        context.getString(R.string.dsc_three), 15.0, R.drawable.img_three, context.getString(R.string.details_three)))

    items.add(MenuItem(0, 1, 0, context.getString(R.string.name_four),
        context.getString(R.string.dsc_four), 15.0, R.drawable.img_four, context.getString(R.string.details_four)))


    items.add(MenuItem(0, 1, 0, context.getString(R.string.name_five),
        context.getString(R.string.dsc_five), 15.0, R.drawable.img_five, context.getString(R.string.details_five)))


    items.add(MenuItem(0, 1, 0, context.getString(R.string.name_six),
        context.getString(R.string.dsc_six), 15.0, R.drawable.img_six, context.getString(R.string.details_six)))


    items.add(MenuItem(0, 1, 1, context.getString(R.string.name_seven),
        context.getString(R.string.dsc_seven), 15.0, R.drawable.img_ning, context.getString(R.string.details_seven)))


    items.add(MenuItem(0, 2, 1, context.getString(R.string.name_eight),
        context.getString(R.string.dsc_eight), 15.0, R.drawable.img_ning, context.getString(R.string.details_eight)))


    items.add(MenuItem(0, 2, 0, context.getString(R.string.name_nine),
        context.getString(R.string.dsc_nine), 15.0, R.drawable.img_ning, context.getString(R.string.details_nine)))


    items.add(MenuItem(0, 2, 1, context.getString(R.string.name_ten),
        context.getString(R.string.dsc_ten), 15.0, R.drawable.img_ning, context.getString(R.string.details_ten)))


    val categories = ArrayList<Category>()
    categories.add(Category(0, "Sushi"))
    categories.add(Category(1, "Pizza"))
    categories.add(Category(2, "Drinks"))

    val filters = ArrayList<Filter>()
    filters.add(Filter(0, "Vegan"))
    filters.add(Filter(1, "Low_Carb-Diet"))
    return MenuData(items, categories, filters)
}