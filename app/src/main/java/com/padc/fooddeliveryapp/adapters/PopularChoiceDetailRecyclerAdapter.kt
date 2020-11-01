package com.padc.fooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import com.padc.fooddeliveryapp.views.viewHolders.BaseViewHolder
import com.padc.fooddeliveryapp.views.viewHolders.PopularChoiceDetailViewHolder
import com.padc.fooddeliveryapp.views.viewHolders.PopularChoiceViewHolder

class PopularChoiceDetailRecyclerAdapter : BaseRecyclerAdapter<BaseViewHolder<FoodItemVO>,FoodItemVO>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<FoodItemVO> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_popular_choice_detail_item, parent, false)
        return PopularChoiceDetailViewHolder(view)
    }
}