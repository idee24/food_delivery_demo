package com.example.food_delivery_demo

import android.content.Context
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksViewModel
import com.example.food_delivery_demo.fragments.HeaderFragment
import com.example.food_delivery_demo.fragments.MenuState
import com.example.food_delivery_demo.networking.*
import com.example.food_delivery_demo.utils.generateMockData
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

    fun retrieveMenu(context: Context) {

        if (Constants.USE_REMOTE_DATA_SOURCE) {
            val requestInterface = Retrofit.Builder()
                .baseUrl(Routes.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(MenuService::class.java)

            mCompositeDisposable?.add(requestInterface.getMenu()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError))
        }
        else {
            handleResponse(ApiResponse("", generateMockData(context)))
        }
    }

    private fun handleResponse(menu: ApiResponse) {
        menu.data?.let { setMenu(it) }
    }

    private fun handleError(error: Throwable) {
        // todo: Show Error Message
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

