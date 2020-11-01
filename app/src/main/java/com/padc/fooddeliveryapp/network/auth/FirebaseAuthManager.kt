package com.padc.fooddeliveryapp.network.auth

import android.net.Uri
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.padc.fooddeliveryapp.data.vos.UserVO


object FirebaseAuthManager : AuthManager {

    private val mFirebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {

        mFirebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful && it.isComplete) {
            onSuccess()
            } else{
                onFailure(it.exception?.message ?: "Please check internet connection")
            }
        }
    }

    override fun register(
        email: String,
        password: String,
        userName: String,
        phone : String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful && it.isComplete){

//                val user = UserVO(email,password,phone,userName,"")
//
//                mFirebaseAuth.currentUser?.uid?.let { it ->
//                    FirebaseDatabase.getInstance().reference.child(
//                        it
//                    ).setValue(user)
//                        .addOnCompleteListener { task ->
//                            if (task.isSuccessful){
//                                onSuccess()
//                            }
//                        }
//                }
                mFirebaseAuth.currentUser?.updateProfile(
                    UserProfileChangeRequest.Builder().setDisplayName(userName).build()
                )
                mFirebaseAuth.currentUser?.updateEmail(email)
                    ?.addOnCompleteListener {
                       //
                    }

                mFirebaseAuth.currentUser?.updatePassword(password)
                    ?.addOnCompleteListener {
                        //
                    }


                onSuccess()

            } else{
                onFailure(it.exception?.message ?: "Please check internet connection")
            }


        }


    }

    override fun updateUserProfile(imageUrl: Uri,onSuccess: (String) -> Unit) {

        mFirebaseAuth.currentUser?.updateProfile(
            UserProfileChangeRequest.Builder()
            .setPhotoUri(imageUrl).build()
        )?.addOnCompleteListener {
            onSuccess("success update profile")
        }

    }

    override fun getCurrentUserProfile() : UserVO{
       val user = mFirebaseAuth?.currentUser
       val email = user?.email
        val name = user?.displayName
        val photoUrl = user?.photoUrl
        val phone = user?.phoneNumber


        return UserVO(email,"",phone,name,photoUrl)
    }

}