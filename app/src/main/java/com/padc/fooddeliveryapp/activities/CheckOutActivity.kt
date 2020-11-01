
package com.padc.fooddeliveryapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.adapters.CheckOutRecyclerAdapter
import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import com.padc.fooddeliveryapp.mvp.presenter.CheckOutPresenter
import com.padc.fooddeliveryapp.mvp.presenter.impls.CheckOutPresenterImpl
import com.padc.fooddeliveryapp.mvp.view.CheckOutView
import kotlinx.android.synthetic.main.activity_check_out2.*
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.bottom_sheet.view.*
import kotlinx.android.synthetic.main.view_holder_new_restaurant_item.*
import kotlinx.android.synthetic.main.viewholder_detail_fooditem.*

class CheckOutActivity : BaseActivity(),CheckOutView {

    companion object {

        const val PARM_NAME = "PARM_NAME"
        const val PARM_DESRIPTION = "PARM_DESRIPTION"
        const val PARM_RATING = "PARM_RATING"
        const val PARM_IMAGE = "PARM_IMAGE"
        fun newIntent(context: Context,
                      restaurant_name: String?, restaurant_description: String?,
                      restaurant_image: String?, restaurant_rating: String?
        ): Intent {
            val intent = Intent(context, CheckOutActivity::class.java)
            intent.putExtra(PARM_NAME, restaurant_name)
            intent.putExtra(PARM_DESRIPTION, restaurant_description)
            intent.putExtra(PARM_RATING, restaurant_rating)
            intent.putExtra(PARM_IMAGE, restaurant_image)
            return intent
        }
    }
    private lateinit var mOrderList: List<FoodItemVO>
    private lateinit var mPresenter : CheckOutPresenter
    private lateinit var mCheckOutAdapter : CheckOutRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out2)

        setUpPresenter()
        init()
        setUpRecyclerView()
        setUpActionListener()


    }

    private fun setUpActionListener() {
        btn_checkout.setOnClickListener {
            showBottomSheetDialogFragment()
        }
    }

    private fun setUpRecyclerView() {

        rv_order.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mCheckOutAdapter = CheckOutRecyclerAdapter(mPresenter)
        rv_order.adapter = mCheckOutAdapter
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(CheckOutPresenterImpl::class.java)
        mPresenter.initPresenter(this)
        mPresenter.onUiReady(this)

    }

    private fun init() {
        //to do
        tv_itemTitle.text = intent.getStringExtra(PARM_NAME).toString()
        tv_itemDetail.text = intent.getStringExtra(PARM_DESRIPTION).toString()
        tv_Rating.text = intent.getStringExtra(PARM_RATING).toString()
        intent.getStringExtra(PARM_IMAGE)?.let {
            Glide.with(this)
                .load(it)
                .into(iv_newRestaurant)
        }
    }

    private fun showBottomSheetDialogFragment() {
        val view = layoutInflater.inflate(R.layout.bottom_sheet, null)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(view)

        view.btn_order.setOnClickListener {
            Toast.makeText(this, "Order  Clicked", Toast.LENGTH_SHORT).show()
            dialog?.dismiss()
            mPresenter.removeAllCartItems(mOrderList)
            this.finish()
        }
        dialog.show()
    }

    override fun showOrderList(orderList: List<FoodItemVO>) {
        mOrderList = orderList
        mCheckOutAdapter.setNewData(orderList.toMutableList())
    }
}