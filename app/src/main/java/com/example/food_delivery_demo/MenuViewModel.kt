package com.example.food_delivery_demo

import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksViewModel
import com.example.food_delivery_demo.fragments.HeaderFragment
import com.example.food_delivery_demo.fragments.MenuState
import com.example.food_delivery_demo.networking.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import kotlin.collections.ArrayList

/**
 *Created by Yerimah on 12/21/2020.
 */


class MenuViewModel(initialSate: MenuState): MavericksViewModel<MenuState>(initialSate) {

    private var mCompositeDisposable: CompositeDisposable? = null
    lateinit var menuData: MenuData

    fun retrieveMenu() {

        println("DDLS Retrieve")
        try {

//            val requestInterface = Retrofit.Builder()
//                .baseUrl(Routes.BASE_URL)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build().create(MenuService::class.java)
//
//            mCompositeDisposable?.add(requestInterface.getMenu()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(this::handleResponse, this::handleError))

            val items = ArrayList<MenuItem>()
            items.add(MenuItem(0, 1, 1, "Drip", "Drop", 0.0, "", "70kg"))
            items.add(MenuItem(0, 1, 1, "Drip", "Drop", 0.0, "", "70kg"))

            val categories = ArrayList<Category>()
            categories.add(Category(0, "Sushi"))
            categories.add(Category(1, "Pizza"))
            categories.add(Category(2, "Drinks"))

            val filters = ArrayList<Filter>()
            filters.add(Filter(0, "Vegan"))
            filters.add(Filter(1, "Low_Carb-Diet"))
            handleResponse(ApiResponse("", MenuData(items, categories, filters)))
        }
        catch (e: Exception) {
            println("DDLS Trace")
            e.printStackTrace()
        }

    }

    private fun handleResponse(menu: ApiResponse) {
        println("DDLS rESPONSE ==> $menu")
        menu.data?.let { setMenu(it) }
    }

    private fun handleError(error: Throwable) {
        println("DDLS Error" + error.printStackTrace())
    }

    fun getDisplayList(): List<Fragment> {
        val displayList = ArrayList<Fragment>()
        displayList.add(HeaderFragment())
        displayList.add(HeaderFragment())
        displayList.add(HeaderFragment())
        return displayList
    }

    private fun setMenu(menuData: MenuData) = setState { copy(menu = menuData) }

}

