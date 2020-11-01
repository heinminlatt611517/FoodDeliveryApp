package com.padc.fooddeliveryapp.data.models

import android.graphics.Bitmap
import android.net.Uri
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import com.padc.fooddeliveryapp.network.FirebaseApi
import com.padc.fooddeliveryapp.network.remoteConfig.FirebaseRemoteConfigManager

interface FoodModel {

    var mFirebaseApi : FirebaseApi

    var mFirebaseRemoteConfigManager : FirebaseRemoteConfigManager

    fun setUpRemoteConfigWithDefaultValue()

    fun fetchRemoteConfigs()

    fun uploadImageAndUpdateGrocery(image : Bitmap,onSuccess : (Uri) -> Unit)
    fun getViewType() : Int


    fun getCategories(onSuccess: (List<CategoryVO>) -> Unit, onFailure: (String) -> Unit)

    fun getRestaurants(onSuccess: (List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit)

    fun getPopularChoiceFoodList(onSuccess: (List<FoodItemVO>) -> Unit, onFailure: (String) -> Unit)

    fun getRestaurantDetailById(id : String,onSuccess: (restaurantVO : RestaurantVO) -> Unit,
                                onFailure: (String) -> Unit)

    fun addFoodItem(foodItemVO: FoodItemVO)

    fun getOrderLists(onSuccess: (restaurants: List<FoodItemVO>) -> Unit, onFailure: (String) -> Unit)

    fun getFoodItemByDocumentId(id : String,onSuccess: (foodItemVo : List<FoodItemVO>) -> Unit,
                                onFailure: (String) -> Unit)

    fun deleteFoodItem(foodItemName: String)

    fun getPopularChoiceByDocumentId(id : String,onSuccess: (foodItemVo : List<FoodItemVO>) -> Unit,
                                     onFailure: (String) -> Unit)
}