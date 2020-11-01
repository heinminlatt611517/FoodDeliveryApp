package com.padc.fooddeliveryapp.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.delegates.DetailItemDelegate
import com.padc.fooddeliveryapp.mvp.view.DetailView

interface DetailPresenter : BasePresenter<DetailView> ,DetailItemDelegate{
    fun onFetchDataById(lifecycleOwner: LifecycleOwner, documentId : String)
}