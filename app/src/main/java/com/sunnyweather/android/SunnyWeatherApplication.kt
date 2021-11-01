package com.sunnyweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * 全局获取Context
 */

class SunnyWeatherApplication : Application() {

    companion object {
        const val TOKEN = "qNqmId0JMEYkz5cC" // 填入申请到的令牌值
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}