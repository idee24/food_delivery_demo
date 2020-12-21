package com.example.food_delivery_demo.utils

import android.app.Application
import android.content.ContextWrapper
import com.airbnb.mvrx.Mavericks

/**
 *Created by Yerimah on 12/17/2020.
 */


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(applicationContext)
    }
}