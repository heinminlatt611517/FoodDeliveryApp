package com.padc.fooddeliveryapp.mvp.presenter.impls

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.data.models.FoodModel
import com.padc.fooddeliveryapp.data.models.FoodModelImpl
import com.padc.fooddeliveryapp.mvp.presenter.HomePresenter
import com.padc.fooddeliveryapp.mvp.view.HomeView

class HomePresenterImpl : HomePresenter,AbstractBasePresenter<HomeView>() {

    private val mFoodModel : FoodModel = FoodModelImpl

    override fun onUiReady(owner: LifecycleOwner) {
        mView?.displayViewType(mFoodModel.getViewType())

        mFoodModel.getRestaurants(
            onSuccess = {
                mView.showRestaurantsList(it)
            },
            onFailure = {
                mView.showErrorMessage(it)
            })

        mFoodModel.getCategories(
            onSuccess = {
                mView.showCategoriesList(it)
            },
            onFailure = {
                mView.showErrorMessage(it)
            })

        mFoodModel.getPopularChoiceFoodList(
            onSuccess = {
                mView.showPopularChoicesFoodItemsLists(it)
            },
            onFailure = {
                mView.showErrorMessage(it)
            }
        )


    }

    override fun onTapRestaurantItem(id : String) {
       mView?.navigateToRestaurantDetailScreen(id)
    }


}