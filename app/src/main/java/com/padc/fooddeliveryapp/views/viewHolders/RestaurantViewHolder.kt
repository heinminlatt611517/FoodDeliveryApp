package com.padc.fooddeliveryapp.views.viewHolders

import android.view.View
import androidx.appcompat.view.menu.MenuView
import com.bumptech.glide.Glide
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import com.padc.fooddeliveryapp.delegates.RestaurantItemDelegate
import kotlinx.android.synthetic.main.view_holder_new_restaurant_item.view.*

class RestaurantViewHolder(itemView : View,private val mDelegate : RestaurantItemDelegate) : BaseViewHolder<RestaurantVO>(itemView) {

    override fun bindData(data: RestaurantVO) {
       mData = data
        data?.let {
            itemView.tv_itemTitle.text =data?.name
            itemView.tv_itemDetail.text = data?.description
            itemView.tv_Rating.text =data?.rating

            Glide.with(itemView.context)
                .load(it.image_url)
                .into(itemView.iv_newRestaurant)
        }

    }

    override fun clickItem(it: RestaurantVO?) {
        mDelegate.onTapRestaurantItem(it?.id.toString())
    }
}