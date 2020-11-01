package com.padc.fooddeliveryapp.data.vos

import com.google.firebase.database.IgnoreExtraProperties


@IgnoreExtraProperties
class CategoryVO(
        var id: Int= 0,
        var image_url: String? = "",
        var name: String? = ""
)