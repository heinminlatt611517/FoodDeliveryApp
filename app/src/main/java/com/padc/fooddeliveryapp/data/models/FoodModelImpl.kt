package com.padc.fooddeliveryapp.data.models

import android.graphics.Bitmap
import android.net.Uri
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import com.padc.fooddeliveryapp.network.CloudFirestoreDatabaseFirebaseApiImpl
import com.padc.fooddeliveryapp.network.FirebaseApi
import com.padc.fooddeliveryapp.network.RealTimeDatabaseFirebaseApiImpl
import com.padc.fooddeliveryapp.network.remoteConfig.FirebaseRemoteConfigManager

object FoodModelImpl : FoodModel {
    override var mFirebaseApi: FirebaseApi = RealTimeDatabaseFirebaseApiImpl

    var mCloudFirestore : FirebaseApi = CloudFirestoreDatabaseFirebaseApiImpl

    override var mFirebaseRemoteConfigManager: FirebaseRemoteConfigManager = FirebaseRemoteConfigManager


    override fun setUpRemoteConfigWithDefaultValue() {
        mFirebaseRemoteConfigManager.setUpRemoteConfigWithDefaultValue()
    }

    override fun fetchRemoteConfigs() {
        mFirebaseRemoteConfigManager.fetchRemoteConfigs()
    }

    override fun uploadImageAndUpdateGrocery(image: Bitmap
    ,onSuccess : (Uri) -> Unit) {
        mFirebaseApi.uploadImageAndEditGrocery(image,onSuccess = onSuccess)
    }

    override fun getViewType(): Int {
        return mFirebaseRemoteConfigManager.getViewType()
    }

    override fun getCategories(onSuccess: (List<CategoryVO>) -> Unit, onFailure: (String) -> Unit) {
        mCloudFirestore.getCategoriesList(onSuccess, onFailure)
    }

    override fun getRestaurants(
        onSuccess: (List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mCloudFirestore.getRestaurantsList(onSuccess, onFailure)
    }

    override fun getPopularChoiceFoodList(
        onSuccess: (List<FoodItemVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mCloudFirestore.getPopularChoiceFoodList(onSuccess,onFailure)
    }

    override fun getRestaurantDetailById(
        id: String,
        onSuccess: (restaurantVO: RestaurantVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mCloudFirestore.getRestaurantDetailById(id,onSuccess,onFailure)
    }

    override fun addFoodItem(foodItemVO: FoodItemVO) {
        mCloudFirestore.addFoodItem(foodItemVO)
    }

    override fun getOrderLists(
        onSuccess: (restaurants: List<FoodItemVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mCloudFirestore.getOrderLists(onSuccess,onFailure)
    }

    override fun getFoodItemByDocumentId(
        id: String,
        onSuccess: (foodItemVo: List<FoodItemVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mCloudFirestore.getFoodItemByDocumentId(id,onSuccess,onFailure)
    }

    override fun deleteFoodItem(foodItemName: String) {
        mCloudFirestore.deleteFoodItem(foodItemName)
    }

    override fun getPopularChoiceByDocumentId(
        id: String,
        onSuccess: (foodItemVo: List<FoodItemVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mCloudFirestore.getPopularChoiceByDocumentId(id,onSuccess,onFailure)
    }
}