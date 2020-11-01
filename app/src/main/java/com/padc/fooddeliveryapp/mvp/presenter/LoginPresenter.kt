package com.padc.fooddeliveryapp.mvp.presenter

import com.padc.fooddeliveryapp.mvp.view.LoginView

interface LoginPresenter  : BasePresenter<LoginView> {

    fun onTapLogin(email: String, password: String)
    fun onTapRegister()

}