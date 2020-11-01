package com.padc.fooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import com.padc.fooddeliveryapp.delegates.RestaurantItemDelegate
import com.padc.fooddeliveryapp.views.viewHolders.BaseViewHolder
import com.padc.fooddeliveryapp.views.viewHolders.RestaurantViewHolder

class RestaurantRecyclerAdapter(delegate : RestaurantItemDelegate,private val mviewType: Int) : BaseRecyclerAdapter<BaseViewHolder<RestaurantVO>,RestaurantVO>(){

    private val mDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<RestaurantVO> {
        return when (mviewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_holder_home_restaurant_item, parent, false)
                RestaurantViewHolder(view, mDelegate)
            }

            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_holder_new_restaurant_item, parent, false)
                RestaurantViewHolder(view, mDelegate)
            }
        }
    }
}