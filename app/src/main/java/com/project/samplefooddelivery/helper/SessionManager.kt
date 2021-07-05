package com.project.samplefooddelivery.helper

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

class SessionManager {

    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var context: Context

    private val PRIVATEMODE = 0
    private val PREFERENCENAME = "sample_food_delivery"

    private val AUTHTOKEN = "auth_token"
    private val USERMOBILENO = "user_mobile_no"
    private val USERID = "user_id"
    private val USERFULLNAME = "user_full_name"


    // Constructor
    @SuppressLint("CommitPrefEdits")
    fun SessionManager(context: Context) {
        this.context = context
        pref = context.getSharedPreferences(PREFERENCENAME, PRIVATEMODE)
        editor = pref.edit()
    }

    //AUTH_TOKEN
    fun getAuthToken(): String? {
        return pref.getString(AUTHTOKEN, "")
    }

    fun setAuthToken(auth_token: String?) {
        editor.putString(AUTHTOKEN, auth_token)
        editor.commit()
    }

    //USER_MOBILE_NO
    fun getUserMobileNo(): String? {
        return pref.getString(USERMOBILENO, "")
    }

    fun setUserMobileNo(user_mobile_no: String?) {
        editor.putString(USERMOBILENO, user_mobile_no)
        editor.commit()
    }

    //USER_ID
    fun getUserId(): Int {
        return pref.getInt(USERID, 0)
    }

    fun setUserId(user_id: Int) {
        editor.putInt(USERID, user_id)
        editor.commit()
    }

    //USER_FULL_NAME
    fun getUserFullName(): String? {
        return pref.getString(USERFULLNAME, "")
    }

    fun setUserFullName(user_id: String?) {
        editor.putString(USERFULLNAME, user_id)
        editor.commit()
    }


}