package com.padc.fooddeliveryapp.views.viewHolders

import android.view.View
import androidx.appcompat.view.menu.MenuView
import com.bumptech.glide.Glide
import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import kotlinx.android.synthetic.main.content_scrolling_layout.view.*
import kotlinx.android.synthetic.main.fragment_account.view.*
import kotlinx.android.synthetic.main.view_holder_popular_choice_item.view.*

class PopularChoiceViewHolder(itemView : View) : BaseViewHolder<FoodItemVO>(itemView) {


    override fun bindData(data: FoodItemVO) {
       mData = data

        itemView.tv_itemTitle.text = data.name
        itemView.tv_itemDetail.text = data.description

        Glide.with(itemView.context)
            .load(data.image_url)
            .into(itemView.iv_popular)
    }

    override fun clickItem(it: FoodItemVO?) {

    }
}