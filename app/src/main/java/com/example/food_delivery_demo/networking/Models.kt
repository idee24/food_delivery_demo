package com.example.food_delivery_demo.networking

/**
 *Created by Yerimah on 12/18/2020.
 */

data class ApiResponse(
    var shortDescription: String?,
    var data: MenuData?
)

data class MenuData(
    var menuItems: List<MenuItem>? = ArrayList(),
    var categories: List<Category>? = ArrayList(),
    var filters: List<Filter>? = ArrayList()
)

data class Filter(
    var filterId: Int?,
    var filterName: String?
)

data class Category(
    var categoryId: Int?,
    var categoryName: String?
)

data class MenuItem(
    var itemId: Int?,
    var categoryId: Int,
    var filterId: Int,
    var name: String,
    var description: String,
    var amount: Double,
    var itemImageUrl: String,
    var itemDetails: String,
)

data class PaymentPayload(
    var items: List<PaymentItem>?,
)

data class PaymentItem(
    var itemId: Int?,
    var count: Int?
)

data class PaymentResponse(
    var isSuccessful: Boolean
)

