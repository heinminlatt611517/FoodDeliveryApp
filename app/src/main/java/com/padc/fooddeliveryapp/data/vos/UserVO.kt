package com.padc.fooddeliveryapp.data.vos

import android.net.Uri

data class UserVO(
    var email: String?,
    var password: String?,
    var phone: String?,
    var userName: String?,
    var photoUrl: Uri?
)
