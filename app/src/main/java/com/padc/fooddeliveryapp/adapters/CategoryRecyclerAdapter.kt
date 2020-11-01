package com.padc.fooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.views.viewHolders.BaseViewHolder
import com.padc.fooddeliveryapp.views.viewHolders.CategoryViewHolder

class CategoryRecyclerAdapter : BaseRecyclerAdapter<BaseViewHolder<CategoryVO>,CategoryVO>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CategoryVO> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_food_item, parent, false)
        return CategoryViewHolder(view)
    }
}