package com.padc.fooddeliveryapp.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.mvp.view.BaseView

interface BasePresenter<V: BaseView> {
    fun onUiReady(owner: LifecycleOwner)
    fun initPresenter(view: V)
}