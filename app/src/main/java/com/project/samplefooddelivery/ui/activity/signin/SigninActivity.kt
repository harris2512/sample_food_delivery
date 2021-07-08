package com.project.samplefooddelivery.ui.activity.signin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.project.samplefooddelivery.databinding.ActivitySigninBinding


class SigninActivity : AppCompatActivity() {


    lateinit var signinBinding: ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        signinBinding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(signinBinding.root)


        init()


    }

    private fun init() {


        signinBinding.edtSigninMobileNo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {
                if (s.toString().trim { it <= ' ' }.length == 10) {
                    submitMobileNoValidation()
                }
            }

        })

        signinBinding.btnSigninVerify.setOnClickListener {
            showToast("you're verified.!")
        }


    }

    private fun submitMobileNoValidation() {
        signinBinding.edtSigninOtp.requestFocus()
        showToast("Sending OTP..")
    }


    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}