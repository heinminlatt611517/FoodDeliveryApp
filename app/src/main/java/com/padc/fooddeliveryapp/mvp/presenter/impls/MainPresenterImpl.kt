package com.padc.fooddeliveryapp.mvp.presenter.impls

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.data.models.FoodModel
import com.padc.fooddeliveryapp.data.models.FoodModelImpl
import com.padc.fooddeliveryapp.mvp.presenter.MainPresenter
import com.padc.fooddeliveryapp.mvp.view.MainView

class MainPresenterImpl : MainPresenter,AbstractBasePresenter<MainView>() {

    private val mFoodModel : FoodModel = FoodModelImpl

    override fun onUiReady(owner: LifecycleOwner) {

    }
}