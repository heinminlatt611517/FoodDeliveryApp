package com.padc.fooddeliveryapp.mvp.presenter

import com.padc.fooddeliveryapp.mvp.view.OfferView

interface OfferPresenter : BasePresenter<OfferView> {

    fun onTapButtonCheckOut()

}