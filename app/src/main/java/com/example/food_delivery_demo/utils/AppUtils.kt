package com.example.food_delivery_demo.utils

import com.example.food_delivery_demo.networking.Category
import com.example.food_delivery_demo.networking.Filter
import com.example.food_delivery_demo.networking.MenuData
import com.example.food_delivery_demo.networking.MenuItem

/**
 *Created by Yerimah on 12/21/2020.
 */
fun generateMockData(): MenuData {

    val items = ArrayList<MenuItem>()
    items.add(MenuItem(0, 0, 1, "Drip", "Drop", 0.0, "", "70kg"))
    items.add(MenuItem(1, 1, 1, "Drip", "Drop", 0.0, "", "70kg"))

    val categories = ArrayList<Category>()
    categories.add(Category(0, "Sushi"))
    categories.add(Category(1, "Pizza"))
    categories.add(Category(2, "Drinks"))

    val filters = ArrayList<Filter>()
    filters.add(Filter(0, "Vegan"))
    filters.add(Filter(1, "Low_Carb-Diet"))
    return MenuData(items, categories, filters)
}