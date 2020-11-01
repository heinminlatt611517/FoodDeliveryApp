package com.padc.fooddeliveryapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.activities.RestaurantDetailActivity
import com.padc.fooddeliveryapp.adapters.CategoryRecyclerAdapter
import com.padc.fooddeliveryapp.adapters.PopularChoiceRecyclerAdapter
import com.padc.fooddeliveryapp.adapters.RestaurantRecyclerAdapter
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.data.vos.FoodItemVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import com.padc.fooddeliveryapp.mvp.presenter.HomePresenter
import com.padc.fooddeliveryapp.mvp.presenter.impls.HomePresenterImpl
import com.padc.fooddeliveryapp.mvp.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var mRestaurantAdapter : RestaurantRecyclerAdapter
private lateinit var mCategoryAdapter : CategoryRecyclerAdapter
private lateinit var mPopularChoiceAdapter : PopularChoiceRecyclerAdapter

private lateinit var mPresenter : HomePresenter

class HomeFragment : Fragment(),HomeView {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()

        setUpRecyclerView()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
        mPresenter.onUiReady(this)
    }

    private fun setUpRecyclerView() {
        rv_category.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rv_popular_choice.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rv_restaurants.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        mCategoryAdapter = CategoryRecyclerAdapter ()
        rv_category.adapter = mCategoryAdapter

        mPopularChoiceAdapter = PopularChoiceRecyclerAdapter()
        rv_popular_choice.adapter = mPopularChoiceAdapter
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun displayViewType(viewType: Int) {
        if(viewType == 0)
        {
            changeViewTypeOne()
        }else
        {
            changeViewTypeTwo()
        }
    }

    override fun showCategoriesList(categoryList: List<CategoryVO>) {
        Log.d("CategoriesList",categoryList.toString())
       mCategoryAdapter.setNewData(categoryList as MutableList<CategoryVO>)
    }

    override fun showRestaurantsList(restaurantList: List<RestaurantVO>) {
       mRestaurantAdapter.setNewData(restaurantList.toMutableList())
    }

    override fun showPopularChoicesFoodItemsLists(popularChoiceList: List<FoodItemVO>) {
        mPopularChoiceAdapter.setNewData(popularChoiceList.toMutableList())
    }

    override fun displayFoodItemsList(foodLists: ArrayList<Int>) {

    }

    override fun displayRestaurantsList(restaurantLists: ArrayList<Int>) {

    }

    override fun navigateToRestaurantDetailScreen(id : String) {
        startActivity(context?.let { RestaurantDetailActivity.newIntent(it,id) })
    }



    private fun changeViewTypeOne()
    {
        location_layout.visibility =View.VISIBLE
        rv_category.visibility = View.VISIBLE
        layout_restaurant.visibility= View.GONE
        layout_popular.visibility =View.GONE
        rv_popular_choice.visibility = View.GONE

        mRestaurantAdapter = RestaurantRecyclerAdapter (mPresenter,0)
        rv_restaurants.adapter = mRestaurantAdapter



    }
    private fun changeViewTypeTwo()
    {
        location_layout.visibility =View.GONE
        rv_category.visibility = View.GONE
        layout_restaurant.visibility= View.VISIBLE
        layout_popular.visibility =View.VISIBLE


        mRestaurantAdapter = RestaurantRecyclerAdapter (mPresenter,1)
        rv_restaurants.adapter = mRestaurantAdapter



    }

    override fun showErrorMessage(message: String) {

    }
}