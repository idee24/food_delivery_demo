package com.example.food_delivery_demo.networking

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 *Created by Yerimah on 12/21/2020.
 */
interface MenuService {

    @GET(Routes.GET_MENU_END_POINT)
    fun getMenu(): Observable<ApiResponse>

    @POST(Routes.PAY_END_POINT)
    fun payForItems(@Body payload: PaymentPayload): Observable<PaymentResponse>
}