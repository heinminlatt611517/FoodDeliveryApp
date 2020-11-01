package com.padc.fooddeliveryapp.data.vos

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
class FoodItemVO(
    var name: String?= "",
    var description: String? = "",
    var price: String? = "",
    var rating: String? = "",
    var image_url: String? = ""

)