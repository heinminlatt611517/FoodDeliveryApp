package com.padc.fooddeliveryapp.mvp.presenter.impls

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.mvp.presenter.IntroductionPresenter
import com.padc.fooddeliveryapp.mvp.view.IntroductionView

class IntroductionPresenterImpl : IntroductionPresenter,AbstractBasePresenter<IntroductionView>() {
    override fun onTapLogin() {
        mView?.navigateToLoginScreen()
    }

    override fun onTapCreateAccount() {
       mView?.navigateToRegisterScreen()
    }

    override fun onTapContinueWithFacebook() {

    }

    override fun onUiReady(owner: LifecycleOwner) {

    }
}