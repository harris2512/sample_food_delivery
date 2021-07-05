package com.project.samplefooddelivery

import android.app.Application

class MyApplication : Application() {

    private var mInstance: MyApplication? = null


    override fun onCreate() {
        super.onCreate()

        mInstance = this

    }


    @Synchronized
    fun getInstance(): MyApplication? {
        return mInstance
    }


}