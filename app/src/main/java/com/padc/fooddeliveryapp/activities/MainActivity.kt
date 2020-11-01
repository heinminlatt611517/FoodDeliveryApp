package com.padc.fooddeliveryapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.fragments.AccountFragment
import com.padc.fooddeliveryapp.fragments.HomeFragment
import com.padc.fooddeliveryapp.fragments.OfferFragment
import com.padc.fooddeliveryapp.mvp.presenter.MainPresenter
import com.padc.fooddeliveryapp.mvp.presenter.impls.MainPresenterImpl
import com.padc.fooddeliveryapp.mvp.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),MainView {

    companion object{

        var mainScreenViewType : Int? = null

        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    private lateinit var mPresenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_main)

        setUpPresenter()
        mPresenter.onUiReady(this)

        changeFragment(HomeFragment.newInstance("", ""))
        nav_main.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.action_restaurant -> {
                        changeFragment(HomeFragment.newInstance("", ""))
                        return true
                    }
                    R.id.action_offer -> {
                        changeFragment(OfferFragment.newInstance("", ""))
                        return true
                    }
                    R.id.action_account -> {
                        changeFragment(AccountFragment.newInstance("", ""))
                        return true
                    }
                }

                return false
            }

        })

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun checkViewType() {
        when (mainScreenViewType) {
            0 -> {
                changeFragment(HomeFragment.newInstance("", ""))
            }

            1 -> {

            }
            else -> {
                changeFragment(HomeFragment.newInstance("", ""))
            }
        }
    }

    private fun changeFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer,fragment).commit()
    }

    override fun displayViewType(viewType: Int) {
       mainScreenViewType = viewType
    }
}