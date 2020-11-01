package com.padc.fooddeliveryapp.mvp.view

import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO

interface DetailView : BaseView {
    fun showRestaurantItemData(restaurantVO: RestaurantVO)
    fun showFoodItemLists(foodItemLists : List<FoodItemVO>)
    fun showPopularChoiceLists(foodItemLists : List<FoodItemVO>)

}