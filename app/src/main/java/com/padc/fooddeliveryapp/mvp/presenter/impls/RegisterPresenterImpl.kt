package com.padc.fooddeliveryapp.mvp.presenter.impls

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.data.models.AuthenticationModel
import com.padc.fooddeliveryapp.data.models.AuthenticationModelImpl
import com.padc.fooddeliveryapp.mvp.presenter.RegisterPresenter
import com.padc.fooddeliveryapp.mvp.view.RegisterView

class RegisterPresenterImpl : RegisterPresenter , AbstractBasePresenter<RegisterView>() {

    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl

    override fun onTapRegister(email: String, password: String, userName: String, phone : String) {
        mAuthenticationModel.register(email = email,password = password,userName = userName,phone = phone,
        onSuccess = {
            mView?.navigateToLoginScreen()
        },
        onFailure = {
            mView?.showErrorMessage(message = it)
        })
    }

    override fun onTapLogin() {
        mView?.navigateToLoginScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }
}