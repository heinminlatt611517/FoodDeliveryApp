package com.padc.fooddeliveryapp.network

import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import com.google.firebase.storage.FirebaseStorage
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import java.io.ByteArrayOutputStream
import java.util.*

object RealTimeDatabaseFirebaseApiImpl : FirebaseApi {
    private val storage = FirebaseStorage.getInstance()
    private val storageReference = storage.reference

    override fun uploadImageAndEditGrocery(image: Bitmap
    ,onSuccess : (Uri) -> Unit) {
        val baos = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        val imageRef = storageReference.child("images/${UUID.randomUUID()}")
        val uploadTask = imageRef.putBytes(data)
        uploadTask.addOnFailureListener {
            //
        }.addOnSuccessListener { taskSnapshot ->
            //
            imageRef.downloadUrl.addOnSuccessListener {
                onSuccess(it)
            }
        }


    }

    override fun getCategoriesList(
        onSuccess: (categories: List<CategoryVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getRestaurantsList(
        onSuccess: (restaurants: List<RestaurantVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getPopularChoiceFoodList(
        onSuccess: (restaurants: List<FoodItemVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getRestaurantDetailById(
        id : String,
        onSuccess: (restaurantVO: RestaurantVO) -> Unit,
        onFailure: (String) -> Unit
    ) {

    }

    override fun addFoodItem(foodItemVO: FoodItemVO) {
        TODO("Not yet implemented")
    }

    override fun deleteFoodItem(foodItemName: String) {
        TODO("Not yet implemented")
    }

    override fun getOrderLists(
        onSuccess: (restaurants: List<FoodItemVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getFoodItemByDocumentId(
        id: String,
        onSuccess: (foodItemVo: List<FoodItemVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getPopularChoiceByDocumentId(
        id: String,
        onSuccess: (foodItemVo: List<FoodItemVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }
}