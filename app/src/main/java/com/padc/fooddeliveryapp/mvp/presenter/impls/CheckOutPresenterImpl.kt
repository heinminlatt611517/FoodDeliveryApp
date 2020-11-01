package com.padc.fooddeliveryapp.mvp.presenter.impls

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.data.models.FoodModel
import com.padc.fooddeliveryapp.data.models.FoodModelImpl
import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import com.padc.fooddeliveryapp.mvp.presenter.CheckOutPresenter
import com.padc.fooddeliveryapp.mvp.view.CheckOutView

class CheckOutPresenterImpl : CheckOutPresenter,AbstractBasePresenter<CheckOutView>() {

    private val mFoodModel : FoodModel = FoodModelImpl


    override fun removeAllCartItems(orderList: List<FoodItemVO>) {
        for(order in orderList) {
            mFoodModel.deleteFoodItem(order.name.toString())
        }
    }

    override fun onUiReady(owner: LifecycleOwner) {
      mFoodModel.getOrderLists(
          onSuccess = {
              mView.showOrderList(it)
          },onFailure = {
              mView.showErrorMessage(it)
          }
      )
    }

    override fun onTapDeleteFood(foodName: String) {
        mFoodModel.deleteFoodItem(foodName)
    }
}