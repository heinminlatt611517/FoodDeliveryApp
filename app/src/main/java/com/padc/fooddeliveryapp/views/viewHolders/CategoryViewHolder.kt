package com.padc.fooddeliveryapp.views.viewHolders

import android.view.View
import androidx.appcompat.view.menu.MenuView
import com.bumptech.glide.Glide
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import kotlinx.android.synthetic.main.view_holder_food_item.view.*


class CategoryViewHolder(itemView : View) : BaseViewHolder<CategoryVO>(itemView) {


    override fun bindData(data: CategoryVO) {
       mData = data
       data?.let {

           itemView.tv_categoryName.text = data.name

           Glide.with(itemView.context)
               .load(data.image_url)
               .into(itemView.iv_category)
       }

    }

    override fun clickItem(it: CategoryVO?) {

    }
}