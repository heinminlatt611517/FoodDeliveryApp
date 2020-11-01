package com.padc.fooddeliveryapp.delegates

import com.padc.fooddeliveryapp.data.vos.FoodItemVO

interface CheckOutOrderItemDelegate {
    fun onTapDeleteFood(foodName : String)
}