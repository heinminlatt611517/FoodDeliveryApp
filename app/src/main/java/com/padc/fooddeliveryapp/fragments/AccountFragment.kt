package com.padc.fooddeliveryapp.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.data.vos.UserVO
import com.padc.fooddeliveryapp.mvp.presenter.AccountPresenter
import com.padc.fooddeliveryapp.mvp.presenter.impls.AccountPresenterImpl
import com.padc.fooddeliveryapp.mvp.view.AccountView
import kotlinx.android.synthetic.main.fragment_account.*
import java.io.IOException


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class AccountFragment : Fragment() ,AccountView{

    private var param1: String? = null
    private var param2: String? = null

    companion object {

        const val PICK_IMAGE_REQUEST = 1111

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AccountFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private lateinit var mPresenter : AccountPresenter

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

        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpActionsListener()

        mPresenter.onUiReady(this)
    }

    private fun setUpActionsListener() {

        ivProfile.setOnClickListener {
            mPresenter.onTapProfileImage()
        }

        tvSave.setOnClickListener {
            mPresenter.onTapSave(ivProfile.drawable.toBitmap())


        }

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(AccountPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }


    override fun openGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }

    override fun showSuccessMessage(message: String) {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }

    override fun showUserProfile(userProfileData: UserVO) {
        bindData(userProfileData)
    }

    private fun bindData(userProfileData: UserVO) {
        tvEmail.setText(userProfileData.email)
        tvPhone.setText(userProfileData.phone)
        Log.d("photoUrl",userProfileData.photoUrl.toString())

        if(userProfileData.photoUrl == null){
            ivProfile.setImageDrawable(resources.getDrawable(R.drawable.img_profile))
        }
        else{

            Glide.with(this)
                .load(userProfileData.photoUrl)
                .into(ivProfile)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            if (data == null || data.data == null) {
                return
            }

            val filePath = data.data
            try {

                filePath?.let {
                    if (Build.VERSION.SDK_INT >= 29) {
                        val source: ImageDecoder.Source? =
                            context?.contentResolver?.let { it1 -> ImageDecoder.createSource(it1, filePath) }

                        val bitmap = source?.let { it1 -> ImageDecoder.decodeBitmap(it1) }
                        bitmap?.let {
                            ivProfile.setImageBitmap(it)
                        }
                    } else {
                        val bitmap = MediaStore.Images.Media.getBitmap(
                            context?.contentResolver, filePath
                        )
                        ivProfile.setImageBitmap(bitmap)
                    }
                }

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }


    }

    override fun showErrorMessage(message: String) {

    }
}