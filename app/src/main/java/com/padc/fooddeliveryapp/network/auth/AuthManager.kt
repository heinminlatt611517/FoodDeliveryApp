package com.padc.fooddeliveryapp.network.auth

import android.net.Uri
import com.padc.fooddeliveryapp.data.vos.UserVO

interface AuthManager {
    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun register(email: String, password: String, userName: String, phone : String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun updateUserProfile(imageUrl: Uri,onSuccess: (String) -> Unit)
    fun getCurrentUserProfile() : UserVO
}