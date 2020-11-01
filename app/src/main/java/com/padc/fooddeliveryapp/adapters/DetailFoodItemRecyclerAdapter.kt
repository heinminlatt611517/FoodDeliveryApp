package com.padc.fooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import com.padc.fooddeliveryapp.delegates.DetailItemDelegate
import com.padc.fooddeliveryapp.views.viewHolders.BaseViewHolder
import com.padc.fooddeliveryapp.views.viewHolders.CategoryViewHolder
import com.padc.fooddeliveryapp.views.viewHolders.DetailFoodItemViewHolder

class DetailFoodItemRecyclerAdapter(delegate : DetailItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<FoodItemVO>,FoodItemVO>(){

    private val mDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<FoodItemVO> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder_fooditem_detail, parent, false)
        return DetailFoodItemViewHolder(mDelegate,view)
    }
}