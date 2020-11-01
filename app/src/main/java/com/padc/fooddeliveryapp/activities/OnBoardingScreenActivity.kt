
package com.padc.fooddeliveryapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.padc.fooddeliveryapp.R
import kotlinx.android.synthetic.main.activity_on_boarding_screen.*

class OnBoardingScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_screen)

        btn_get_started.setOnClickListener {
            startActivity(IntroductionScreenActivity.newIntent(this))
        }
    }
}