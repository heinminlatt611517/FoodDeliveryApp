package com.padc.fooddeliveryapp.data.models

import android.net.Uri
import com.google.firebase.ktx.Firebase
import com.padc.fooddeliveryapp.data.vos.UserVO
import com.padc.fooddeliveryapp.network.auth.AuthManager
import com.padc.fooddeliveryapp.network.auth.FirebaseAuthManager

object AuthenticationModelImpl : AuthenticationModel {
    override var mAuthManager: AuthManager  = FirebaseAuthManager


    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
       mAuthManager.login(email,password,onSuccess,onFailure)
    }

    override fun register(
        email: String,
        password: String,
        userName: String,
        phone : String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mAuthManager.register(email,password,userName,phone,onSuccess,onFailure)
    }

    override fun updateUserProfile(imageUrl: Uri,onSuccess: (String) -> Unit) {
        mAuthManager.updateUserProfile(imageUrl,onSuccess)
    }

    override fun getCurrentUserProfile(): UserVO {
       return mAuthManager.getCurrentUserProfile()
    }
}