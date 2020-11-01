package com.padc.fooddeliveryapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.mvp.presenter.RegisterPresenter
import com.padc.fooddeliveryapp.mvp.presenter.impls.RegisterPresenterImpl
import com.padc.fooddeliveryapp.mvp.view.RegisterView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btnRegister
import kotlinx.android.synthetic.main.activity_login.etEmail
import kotlinx.android.synthetic.main.activity_login.etPassword
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity :BaseActivity(),RegisterView {

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }


    lateinit var mPresenter : RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setUpPresenter()
        setUpActionListeners()

    }

    private fun setUpActionListeners() {
      btnRegister.setOnClickListener {
          if (isValidate()){
              mPresenter.onTapRegister(
                  etEmail.text.toString(),
                  etPassword.text.toString(),
                  etUserName.text.toString(),
                  etPhone.text.toString()
              )
          }
      }

        tvLogin.setOnClickListener {
            mPresenter.onTapLogin()
        }
    }

    private fun setUpPresenter() {
      mPresenter = ViewModelProviders.of(this).get(RegisterPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun navigateToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
    }

    fun isValidate() : Boolean{
        return if ((!etEmail.text.toString().isNullOrEmpty()) && (!etPassword.text.toString().isNullOrEmpty())
            && (!etUserName.text.toString().isNullOrEmpty()) && (!etPhone.text.toString().isNullOrEmpty())){
            true
        } else{
            etEmail.error = "Error"
            etPassword.error = "Error"
            etUserName.error = "Error"
            etPhone.error = "Error"
            false
        }

    }
}