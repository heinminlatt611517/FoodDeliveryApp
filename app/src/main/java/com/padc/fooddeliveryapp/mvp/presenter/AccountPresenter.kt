package com.padc.fooddeliveryapp.mvp.presenter

import android.graphics.Bitmap
import com.padc.fooddeliveryapp.mvp.view.AccountView

interface AccountPresenter : BasePresenter<AccountView> {

    fun onTapProfileImage()

    fun onTapSave(bitmap: Bitmap)

    fun onTapCancel()
}