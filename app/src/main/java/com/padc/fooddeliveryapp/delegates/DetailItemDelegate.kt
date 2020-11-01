package com.padc.fooddeliveryapp.delegates

import com.padc.fooddeliveryapp.data.vos.FoodItemVO

interface DetailItemDelegate {
    fun onTapAddToCard(foodData : FoodItemVO)

}