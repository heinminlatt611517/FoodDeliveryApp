package com.padc.fooddeliveryapp.network

import android.graphics.Bitmap
import android.net.Uri
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO

interface FirebaseApi {
    fun uploadImageAndEditGrocery(image : Bitmap,onSuccess : (Uri) -> Unit)

    fun getCategoriesList(onSuccess: (categories: List<CategoryVO>) -> Unit, onFailure: (String) -> Unit)
    fun getRestaurantsList(onSuccess: (restaurants: List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit)

    fun getPopularChoiceFoodList(onSuccess: (restaurants: List<FoodItemVO>) -> Unit, onFailure: (String) -> Unit)

    fun getRestaurantDetailById(id : String,onSuccess: (restaurantVO : RestaurantVO) -> Unit,
                                onFailure: (String) -> Unit)

    fun addFoodItem(foodItemVO: FoodItemVO)

    fun deleteFoodItem(foodItemName: String)

    fun getOrderLists(onSuccess: (restaurants: List<FoodItemVO>) -> Unit, onFailure: (String) -> Unit)

    fun getFoodItemByDocumentId(id : String,onSuccess: (foodItemVo : List<FoodItemVO>) -> Unit,
                                onFailure: (String) -> Unit)

    fun getPopularChoiceByDocumentId(id : String,onSuccess: (foodItemVo : List<FoodItemVO>) -> Unit,
                                onFailure: (String) -> Unit)

}