package com.padc.fooddeliveryapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.mvp.presenter.OfferPresenter
import com.padc.fooddeliveryapp.mvp.presenter.impls.OfferPresenterImpl
import com.padc.fooddeliveryapp.mvp.view.OfferView
import kotlinx.android.synthetic.main.fragment_offer.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class OfferFragment : Fragment() ,OfferView{

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mPresenter : OfferPresenter

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

        return inflater.inflate(R.layout.fragment_offer, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpActionsListener()

    }

    private fun setUpActionsListener() {


    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(OfferPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OfferFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun showBottomSheetDialogFragment() {
        val bottomSheetDialogFragment=BottomSheetFragment()
        activity?.supportFragmentManager?.let {
                it -> bottomSheetDialogFragment.show(it,bottomSheetDialogFragment.tag)
        }
    }

    override fun showErrorMessage(message: String) {

    }
}