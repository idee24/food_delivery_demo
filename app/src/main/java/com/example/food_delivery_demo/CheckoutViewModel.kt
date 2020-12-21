package com.example.food_delivery_demo

import androidx.lifecycle.ViewModel
import com.example.food_delivery_demo.networking.MenuItem

/**
 *Created by Yerimah on 12/21/2020.
 */
class CheckoutViewModel: ViewModel() {

    private val paymentList = LinkedHashMap<Int, MenuItem>()

    fun addToCart(menuItem: MenuItem) {

        if (paymentList[menuItem.itemId] != null) {
            paymentList[menuItem.itemId]?.orderCount = paymentList[menuItem.itemId]?.orderCount?.inc() ?: 1
        }
        else {
            paymentList[menuItem.itemId ?: 0] = menuItem
        }
    }

    fun getCartItems(): List<MenuItem> {
        return ArrayList<MenuItem>(paymentList.values)
    }

    fun removeFromCart(menuItem: MenuItem) {

        if (menuItem.orderCount <= 1) {
            paymentList.remove(menuItem.itemId)
        }
        else {
            paymentList[menuItem.itemId]?.orderCount = paymentList[menuItem.itemId]?.orderCount?.dec() ?: 1
        }
    }

}
