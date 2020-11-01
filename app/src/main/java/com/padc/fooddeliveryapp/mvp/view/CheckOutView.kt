package com.padc.fooddeliveryapp.mvp.view

import com.padc.fooddeliveryapp.data.vos.FoodItemVO

interface CheckOutView : BaseView{
    fun showOrderList(orderList: List<FoodItemVO>)
}