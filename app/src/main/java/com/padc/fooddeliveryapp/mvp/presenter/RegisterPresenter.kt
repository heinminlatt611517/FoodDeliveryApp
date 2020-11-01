package com.padc.fooddeliveryapp.mvp.presenter


import com.padc.fooddeliveryapp.mvp.view.RegisterView

interface RegisterPresenter : BasePresenter<RegisterView> {
    fun onTapRegister(email: String, password: String, userName: String, phone : String)
    fun onTapLogin()
}