package com.padc.fooddeliveryapp.views.viewHolders

import android.view.View
import androidx.appcompat.view.menu.MenuView
import com.bumptech.glide.Glide
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import com.padc.fooddeliveryapp.delegates.DetailItemDelegate
import kotlinx.android.synthetic.main.view_holder_food_item.view.*
import kotlinx.android.synthetic.main.viewholder_fooditem_detail.view.*


class DetailFoodItemViewHolder(private val mDelegate : DetailItemDelegate,itemView : View) : BaseViewHolder<FoodItemVO>(itemView) {


    override fun bindData(data: FoodItemVO) {
       mData = data
        itemView.tv_restaurant_name.text = data.name
        itemView.tv_restaurant_description.text = data.description
        itemView.tv_restaurant_rating.text = data.rating
        itemView.tv_restaurant_price.text = data.price

        Glide.with(itemView.context)
            .load(data.image_url)
            .into(itemView.iv_restaurant)

        itemView.btn_plus.setOnClickListener {
            mDelegate.onTapAddToCard(data)
        }
    }

    override fun clickItem(it: FoodItemVO?) {

    }
}