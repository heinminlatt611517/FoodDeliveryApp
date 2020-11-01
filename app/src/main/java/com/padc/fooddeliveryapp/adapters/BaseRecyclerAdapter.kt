package com.padc.fooddeliveryapp.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.fooddeliveryapp.views.viewHolders.BaseViewHolder

abstract class BaseRecyclerAdapter<T : BaseViewHolder<W>,W> : RecyclerView.Adapter<T>() {

    var mData : MutableList<W> = arrayListOf()
    override fun getItemCount(): Int {
        return mData.count()
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }

    fun setNewData(data : MutableList<W>){
        mData=data
        notifyDataSetChanged()
    }

    fun appendNewData(data: MutableList<W>){
        mData.addAll(data)
        notifyDataSetChanged()
    }


}