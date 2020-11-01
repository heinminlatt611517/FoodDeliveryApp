package com.padc.fooddeliveryapp.mvp.presenter.impls

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.data.models.AuthenticationModel
import com.padc.fooddeliveryapp.data.models.AuthenticationModelImpl
import com.padc.fooddeliveryapp.data.models.FoodModel
import com.padc.fooddeliveryapp.data.models.FoodModelImpl
import com.padc.fooddeliveryapp.mvp.presenter.LoginPresenter
import com.padc.fooddeliveryapp.mvp.view.LoginView

class LoginPresenterImpl : LoginPresenter , AbstractBasePresenter<LoginView>() {

    private val mAuthenticatioModel: AuthenticationModel = AuthenticationModelImpl

    private val mFoodModel : FoodModel = FoodModelImpl

    override fun onTapLogin(email: String, password: String) {
        mAuthenticatioModel.login(email = email,password = password,
        onSuccess = {
            mView?.navigateToMainScreen()
        },
        onFailure = {
            mView?.showErrorMessage(it)
        })
    }

    override fun onTapRegister() {
        mView?.navigateToRegisterScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mFoodModel.setUpRemoteConfigWithDefaultValue()
        mFoodModel.fetchRemoteConfigs()
    }
}