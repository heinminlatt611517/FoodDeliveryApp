package com.padc.fooddeliveryapp.views.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var mData : T?=null

    init {
        itemView.setOnClickListener {
            mData?.let { clickItem(it) }
        }
    }

    abstract fun clickItem(it: T?)
    abstract fun bindData(data  : T)
}