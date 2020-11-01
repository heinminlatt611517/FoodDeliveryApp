package com.padc.fooddeliveryapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.adapters.DetailFoodItemRecyclerAdapter
import com.padc.fooddeliveryapp.adapters.PopularChoiceDetailRecyclerAdapter
import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import com.padc.fooddeliveryapp.mvp.presenter.DetailPresenter
import com.padc.fooddeliveryapp.mvp.presenter.impls.DetailPresenterImpl
import com.padc.fooddeliveryapp.mvp.view.DetailView
import kotlinx.android.synthetic.main.activity_restaurant_detail.*
import kotlinx.android.synthetic.main.content_scrolling_layout.*

class RestaurantDetailActivity : BaseActivity(), DetailView {

    companion object {

        const val PARM_DOCUMENTID = "Document ID"

        fun newIntent(context: Context, id: String): Intent {
            val intent = Intent(context, RestaurantDetailActivity::class.java)
            intent.putExtra(PARM_DOCUMENTID, id)
            return intent
        }
    }

    private lateinit var mPresenter: DetailPresenter
    private lateinit var mDetailFoodItemAdapter: DetailFoodItemRecyclerAdapter
    private lateinit var mPopularChoiceDetailAdapter: PopularChoiceDetailRecyclerAdapter
    private lateinit var mRestaurantData: RestaurantVO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)

        setUpPresenter()
        setUpRecyclerView()
        setUpActionListener()
    }

    private fun setUpActionListener() {
        btn_viewcart.setOnClickListener {
            startActivity(
                CheckOutActivity.newIntent(
                    this, mRestaurantData.name,
                    mRestaurantData.description,
                    mRestaurantData.image_url, mRestaurantData.rating
                )
            )
        }
    }

    private fun setUpRecyclerView() {
        rv_detail_popular_choice.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_detail_fooditem.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        mDetailFoodItemAdapter = DetailFoodItemRecyclerAdapter(mPresenter)
        rv_detail_fooditem.adapter = mDetailFoodItemAdapter

        mPopularChoiceDetailAdapter = PopularChoiceDetailRecyclerAdapter()
        rv_detail_popular_choice.adapter = mPopularChoiceDetailAdapter
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
        mPresenter.onFetchDataById(
            this,
            intent.getStringExtra(PARM_DOCUMENTID).toString()
        )
    }

    override fun showRestaurantItemData(restaurantVO: RestaurantVO) {
        mRestaurantData = restaurantVO
        detail_description.text = restaurantVO?.description
        tv_detail_rating.text = restaurantVO?.rating
        tv_detail_title.text = restaurantVO?.name

        Glide.with(this)
            .load(mRestaurantData.image_url)
            .into(iv_detail_image)

    }

    override fun showFoodItemLists(foodItemLists: List<FoodItemVO>) {
        mDetailFoodItemAdapter.setNewData(foodItemLists.toMutableList())
    }

    override fun showPopularChoiceLists(foodItemLists: List<FoodItemVO>) {
        mPopularChoiceDetailAdapter.setNewData(foodItemLists.toMutableList())
    }
}