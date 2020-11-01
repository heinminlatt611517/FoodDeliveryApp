package com.padc.fooddeliveryapp.mvp.presenter.impls

import androidx.lifecycle.ViewModel
import com.padc.fooddeliveryapp.mvp.presenter.BasePresenter
import com.padc.fooddeliveryapp.mvp.view.BaseView

abstract class AbstractBasePresenter<T: BaseView> : BasePresenter<T>, ViewModel() {

    protected lateinit var mView : T

    override fun initPresenter(view: T){
        mView = view
    }
}