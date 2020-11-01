package com.padc.fooddeliveryapp.mvp.view

import com.padc.fooddeliveryapp.data.vos.UserVO

interface AccountView : BaseView {
    fun openGallery()
    fun showSuccessMessage(message : String)
    fun showUserProfile(userProfileData : UserVO)
}