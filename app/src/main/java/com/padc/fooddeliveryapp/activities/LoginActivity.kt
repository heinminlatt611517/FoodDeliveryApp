package com.padc.fooddeliveryapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.mvp.presenter.LoginPresenter
import com.padc.fooddeliveryapp.mvp.presenter.impls.LoginPresenterImpl
import com.padc.fooddeliveryapp.mvp.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(),LoginView {

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    private lateinit var mPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setUpPresenter()
        setUpActionListeners()

        mPresenter.onUiReady(this)
    }

    private fun setUpActionListeners() {

        btnRegister.setOnClickListener {
            mPresenter.onTapRegister()
        }

        btnLogin.setOnClickListener {
            if (isValidate()){
                mPresenter.onTapLogin(
                    etEmail.text.toString(), etPassword.text.toString())
            }

        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(LoginPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun navigateToMainScreen() {
        startActivity(MainActivity.newIntent(this))
    }

    override fun navigateToRegisterScreen() {
        startActivity(RegisterActivity.newIntent(this))
    }

    fun isValidate() : Boolean{
        return if ((!etEmail.text.toString().isNullOrEmpty()) && (!etPassword.text.toString().isNullOrEmpty())){
            true
        } else{
            etEmail.error = "Error"
            etPassword.error = "Error"
            false
        }

    }
}