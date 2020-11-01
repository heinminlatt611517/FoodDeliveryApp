package com.padc.fooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import com.padc.fooddeliveryapp.delegates.CheckOutOrderItemDelegate
import com.padc.fooddeliveryapp.delegates.RestaurantItemDelegate
import com.padc.fooddeliveryapp.views.viewHolders.BaseViewHolder
import com.padc.fooddeliveryapp.views.viewHolders.CategoryViewHolder
import com.padc.fooddeliveryapp.views.viewHolders.CheckOutViewHolder
import com.padc.fooddeliveryapp.views.viewHolders.RestaurantViewHolder

class CheckOutRecyclerAdapter(delegate : CheckOutOrderItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<FoodItemVO>,FoodItemVO>(){
    private val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<FoodItemVO> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_check_out_item, parent, false)
        return CheckOutViewHolder(mDelegate,view)
    }
}