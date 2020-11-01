package com.padc.fooddeliveryapp.data.models

import android.net.Uri
import com.padc.fooddeliveryapp.data.vos.UserVO
import com.padc.fooddeliveryapp.network.auth.AuthManager

interface AuthenticationModel {
    var mAuthManager: AuthManager

    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)

    fun register(
        email: String,
        password: String,
        userName: String,
        phone : String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

    fun updateUserProfile(imageUrl: Uri,onSuccess: (String) -> Unit)

    fun getCurrentUserProfile() : UserVO

}