package com.padc.fooddeliveryapp.mvp.presenter.impls

import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.data.models.AuthenticationModel
import com.padc.fooddeliveryapp.data.models.AuthenticationModelImpl
import com.padc.fooddeliveryapp.data.models.FoodModel
import com.padc.fooddeliveryapp.data.models.FoodModelImpl
import com.padc.fooddeliveryapp.mvp.presenter.AccountPresenter
import com.padc.fooddeliveryapp.mvp.view.AccountView

class AccountPresenterImpl : AccountPresenter,AbstractBasePresenter<AccountView>(){

    private val mFoodModel : FoodModel = FoodModelImpl

    private val mAuthManager : AuthenticationModel = AuthenticationModelImpl
    override fun onTapProfileImage() {
        mView?.openGallery()
    }

    override fun onTapSave(bitmap: Bitmap) {
        mFoodModel.uploadImageAndUpdateGrocery(bitmap,
        onSuccess = {
            mAuthManager.updateUserProfile(it,
            onSuccess = { it ->
                mView?.showSuccessMessage(it)
            })
        })
    }


    override fun onTapCancel() {

    }

    override fun onUiReady(owner: LifecycleOwner) {
       mAuthManager.getCurrentUserProfile()?.let {
           mView.showUserProfile(it)
       }
    }
}