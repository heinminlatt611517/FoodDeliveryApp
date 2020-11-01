package com.padc.fooddeliveryapp.mvp.presenter

import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import com.padc.fooddeliveryapp.delegates.CheckOutOrderItemDelegate
import com.padc.fooddeliveryapp.mvp.view.CheckOutView

interface CheckOutPresenter : BasePresenter<CheckOutView> ,CheckOutOrderItemDelegate{
    fun removeAllCartItems(orderList: List<FoodItemVO>)
}