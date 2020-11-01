package com.padc.fooddeliveryapp.mvp.presenter

import com.padc.fooddeliveryapp.mvp.view.IntroductionView

interface IntroductionPresenter : BasePresenter<IntroductionView> {
    fun onTapLogin()
    fun onTapCreateAccount()
    fun onTapContinueWithFacebook()
}