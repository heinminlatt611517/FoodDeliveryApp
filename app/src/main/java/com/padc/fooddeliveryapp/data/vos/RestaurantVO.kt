package com.padc.fooddeliveryapp.data.vos

import com.google.firebase.database.IgnoreExtraProperties


@IgnoreExtraProperties
class RestaurantVO(
        var id: String?= "",
        var description: String? = "",
        var image_url: String? = "",
        var name: String? = "",
        var rating: String? = ""
)