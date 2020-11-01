package com.padc.fooddeliveryapp.views.viewHolders

import android.view.View
import androidx.appcompat.view.menu.MenuView
import com.bumptech.glide.Glide
import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import kotlinx.android.synthetic.main.content_scrolling_layout.view.*
import kotlinx.android.synthetic.main.fragment_account.view.*
import kotlinx.android.synthetic.main.view_holder_popular_choice_detail_item.view.*
import kotlinx.android.synthetic.main.view_holder_popular_choice_item.view.*

class PopularChoiceDetailViewHolder(itemView : View) : BaseViewHolder<FoodItemVO>(itemView) {


    override fun bindData(data: FoodItemVO) {
       mData = data
       itemView.tv_detail_popular_choice_name.text = data.name
        itemView.tv_detail_popular_choice_price.text = data.price

        Glide.with(itemView.context)
            .load(data.image_url)
            .into(itemView.iv_detail_popular_choice)

    }

    override fun clickItem(it: FoodItemVO?) {

    }
}