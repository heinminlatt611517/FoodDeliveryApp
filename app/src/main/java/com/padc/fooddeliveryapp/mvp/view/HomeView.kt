package com.padc.fooddeliveryapp.mvp.view

import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO

interface HomeView : BaseView {
    fun displayFoodItemsList(foodLists : ArrayList<Int>)

    fun displayRestaurantsList(restaurantLists : ArrayList<Int>)

    fun navigateToRestaurantDetailScreen(id : String)

    fun displayViewType(viewType : Int)

    fun showCategoriesList(categoryList: List<CategoryVO>)
    fun showRestaurantsList(restaurantList: List<RestaurantVO>)
    fun showPopularChoicesFoodItemsLists(popularChoiceList: List<FoodItemVO>)
}