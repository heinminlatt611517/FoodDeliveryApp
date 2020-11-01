package com.padc.fooddeliveryapp.mvp.presenter

import com.padc.fooddeliveryapp.delegates.RestaurantItemDelegate
import com.padc.fooddeliveryapp.mvp.view.HomeView

interface HomePresenter : BasePresenter<HomeView> ,RestaurantItemDelegate{
}