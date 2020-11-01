package com.padc.fooddeliveryapp.network

import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.gson.Gson
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import java.io.ByteArrayOutputStream
import java.util.*

object CloudFirestoreDatabaseFirebaseApiImpl : FirebaseApi {
    val db = Firebase.firestore
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
        onFailure: (String) -> Unit
    ) {
        db.collection("categories")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: "Please check connection")
                } ?: run{

                    val categoryList: MutableList<CategoryVO> = arrayListOf()

                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val data = document.data
                        var category = CategoryVO()
                        category.id = (data?.get("id") as Long).toInt()
                        category.name = data["name"] as String
                        category.image_url = data["image_url"] as String

                        categoryList.add(category)
                    }

                    onSuccess(categoryList)
                }
            }
    }

    override fun getOrderLists(
        onSuccess: (restaurants: List<FoodItemVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("orders")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: "Please check connection")
                } ?: run{

                    val orderList: MutableList<FoodItemVO> = arrayListOf()

                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val data = document.data
                        var itemVO  = FoodItemVO()
                        itemVO.name =  data?.get("name") as String
                        itemVO.description =data["description"] as String
                        itemVO.image_url = data["image_url"] as String
                        itemVO.price = data["price"] as String
                        itemVO.rating = data["rating"] as String

                        orderList.add(itemVO)
                    }

                    onSuccess(orderList)
                }
            }
    }

    override fun getRestaurantsList(
        onSuccess: (restaurants: List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("restaurants")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: "Please check connection")
                } ?: run{

                    val restaurantList: MutableList<RestaurantVO> = arrayListOf()

                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val data = document.data
                        data?.put("id", document.id)
                        val dataJson = Gson().toJson(data)
                        val docsData = Gson().fromJson<RestaurantVO>(dataJson, RestaurantVO::class.java)
                        restaurantList.add(docsData)
                    }

                    onSuccess(restaurantList)
                }
            }
    }

    override fun getRestaurantDetailById(
        id : String,
        onSuccess: (restaurantVO: RestaurantVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        var restaurant: RestaurantVO  = RestaurantVO()
        db.collection("restaurants").document(id)
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: "Please check connection")
                } ?: run{

                    val data = value?.data
                    val restaurantVO = RestaurantVO()
                    restaurantVO.name = data?.get("name") as String
                    restaurantVO.description = data["description"] as String?
                    restaurantVO.image_url = data["image_url"] as String?
                    restaurantVO.rating = data["rating"] as String?

                    restaurant = restaurantVO
                }
                onSuccess(restaurant)
            }
    }

    override fun getPopularChoiceFoodList(
        onSuccess: (restaurants: List<FoodItemVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("restaurants").
        document("93b05340-1c06-11eb-8d64-15188f84a29e").collection("restaurants")
            .document("id")
            .collection("foodItems")

            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: "Please check connection")
                } ?: run{

                    val popularList: MutableList<FoodItemVO> = arrayListOf()

                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val data = document.data
                        data?.put("id", document.id)
                        val dataJson = Gson().toJson(data)
                        val docsData = Gson().fromJson<FoodItemVO>(dataJson, FoodItemVO::class.java)
                        popularList.add(docsData)
                    }

                    onSuccess(popularList)
                }
            }
    }




    override fun addFoodItem(foodItemVO: FoodItemVO) {
        db.collection("orders")
            .document(foodItemVO?.name.toString())
            .set(foodItemVO)
            .addOnSuccessListener { Log.d("Success", "Successfully added grocery") }
            .addOnFailureListener { Log.d("Failure", "Failed to add grocery") }
    }


    override fun getFoodItemByDocumentId(
        id: String,
        onSuccess: (foodItemVo: List<FoodItemVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("restaurants").document(id)
            .collection("restaurants")
            .document("id")
            .collection("foodItems")

            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: "Please check connection")
                } ?: run {

                    val foodItemLists: MutableList<FoodItemVO> = arrayListOf()

                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val data = document.data
                        data?.put("id", document.id)
                        val dataJson = Gson().toJson(data)
                        val docsData = Gson().fromJson<FoodItemVO>(dataJson, FoodItemVO::class.java)
                        foodItemLists.add(docsData)
                    }

                    onSuccess(foodItemLists)
                }
            }

    }

    override fun deleteFoodItem(foodItemName: String) {
        db.collection("orders")
            .document(foodItemName)
            .delete()
            .addOnSuccessListener { Log.d("Success", "Successfully deleted grocery") }
            .addOnFailureListener { Log.d("Failure", "Failed to delete grocery") }
    }

    override fun getPopularChoiceByDocumentId(
        id: String,
        onSuccess: (foodItemVo: List<FoodItemVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("restaurants").document(id)
            .collection("restaurants")
            .document("id")
            .collection("foodItems")
            .limit(3)

            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: "Please check connection")
                } ?: run {

                    val foodItemLists: MutableList<FoodItemVO> = arrayListOf()

                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val data = document.data
                        data?.put("id", document.id)
                        val dataJson = Gson().toJson(data)
                        val docsData = Gson().fromJson<FoodItemVO>(dataJson, FoodItemVO::class.java)
                        foodItemLists.add(docsData)
                    }

                    onSuccess(foodItemLists)
                }
            }
    }




}