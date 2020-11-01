package com.padc.fooddeliveryapp.mvp.presenter.impls

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.mvp.presenter.OfferPresenter
import com.padc.fooddeliveryapp.mvp.view.OfferView

class OfferPresenterImpl : OfferPresenter,AbstractBasePresenter<OfferView>() {
    override fun onTapButtonCheckOut() {
        mView?.showBottomSheetDialogFragment()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }
}