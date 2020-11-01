package com.padc.fooddeliveryapp.mvp.presenter.impls

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.data.models.FoodModel
import com.padc.fooddeliveryapp.data.models.FoodModelImpl
import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import com.padc.fooddeliveryapp.mvp.presenter.DetailPresenter
import com.padc.fooddeliveryapp.mvp.view.DetailView

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {

    private val mFoodModel: FoodModel = FoodModelImpl

    override fun onFetchDataById(lifecycleOwner: LifecycleOwner, documentId: String) {

        mFoodModel.getRestaurantDetailById(documentId
            , onSuccess = {
                mView.showRestaurantItemData(it)
            }, onFailure = {
                mView.showErrorMessage(it)
            })

        mFoodModel.getFoodItemByDocumentId(documentId,
            onSuccess = {
                mView.showFoodItemLists(it)
            }, onFailure = {
                mView.showErrorMessage(it)
            })

        mFoodModel.getPopularChoiceByDocumentId(documentId,
            onSuccess = {
                mView.showPopularChoiceLists(it)
            },onFailure = {
                mView.showErrorMessage(it)
            }
        )

    }

    override fun onUiReady(owner: LifecycleOwner) {

    }

    override fun onTapAddToCard(foodData: FoodItemVO) {
        mFoodModel.addFoodItem(foodData)
    }
}