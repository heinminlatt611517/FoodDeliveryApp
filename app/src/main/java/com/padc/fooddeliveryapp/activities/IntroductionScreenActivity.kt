package com.padc.fooddeliveryapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.mvp.presenter.IntroductionPresenter
import com.padc.fooddeliveryapp.mvp.presenter.impls.IntroductionPresenterImpl
import com.padc.fooddeliveryapp.mvp.view.IntroductionView
import kotlinx.android.synthetic.main.activity_introduction_screen.*

class IntroductionScreenActivity : BaseActivity(),IntroductionView {


    companion object{
        fun newIntent(context: Context) : Intent{
            return Intent(context,IntroductionScreenActivity::class.java)
        }
    }

    private lateinit var layouts: IntArray
    private lateinit var mViewPagerAdapter: ViewPagerAdapter
    private lateinit var mPresenter : IntroductionPresenter

    private val viewPagerPageChangeListener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageSelected(position: Int) {

            indicator.setCurrentPage(position)
            if (position == layouts.size - 1) {
            } else {
            }
        }

        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
        override fun onPageScrollStateChanged(arg0: Int) {}
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction_screen)

        setUpPresenter()
        setUpActionsListener()
        setUpViewPagerWithIndicator()
    }

    private fun setUpActionsListener() {

        tvLogin.setOnClickListener {
            mPresenter.onTapLogin()
        }

        btn_createAccount.setOnClickListener {
            mPresenter.onTapCreateAccount()
        }

    }

    private fun setUpPresenter() {
        mPresenter=ViewModelProviders.of(this).get(IntroductionPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }


    private fun setUpViewPagerWithIndicator() {
        indicator.setPageIndicators(3)
        indicator.setActiveIndicatorColor(android.R.color.holo_orange_light)
        indicator.setInactiveIndicatorColor(android.R.color.darker_gray)


        layouts = intArrayOf(
            R.layout.activity_intro_screen_one,
            R.layout.activity_intro_screen_two,
            R.layout.activity_intro_screen_three
        )

        mViewPagerAdapter = ViewPagerAdapter()
        viewPager.adapter=mViewPagerAdapter
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener)



    }


    inner class ViewPagerAdapter : PagerAdapter() {

       private var layoutInflater: LayoutInflater? = null

       override fun instantiateItem(container: ViewGroup, position: Int): Any {

           layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

           val view =  layoutInflater!!.inflate(layouts[position], container, false)
           container.addView(view)
           return view
       }

       override fun isViewFromObject(view: View, `object`: Any): Boolean {
           return view === `object`
       }

       override fun getCount(): Int {
           return layouts.count()
       }

       override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

           val view = `object` as View
           container.removeView(view)
       }
   }

    override fun navigateToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
    }

    override fun navigateToRegisterScreen() {
        startActivity(RegisterActivity.newIntent(this))
    }


}

