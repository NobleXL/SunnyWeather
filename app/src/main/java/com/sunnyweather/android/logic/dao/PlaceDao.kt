package com.sunnyweather.android.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.sunnyweather.android.SunnyWeatherApplication
import com.sunnyweather.android.logic.model.PlaceResponse

/**
 * 对选择的城市进行记录
 */
object PlaceDao {

    // 存储数据
    fun savePlace(place: PlaceResponse.Place) {
        sharedPreferences().edit {
            putString("place", Gson().toJson(place)) // 使用Gson将Place对象转换成一个JSON字符串
        }
    }

    // 读取数据
    fun getSavedPlace(): PlaceResponse.Place {
        val placeJson = sharedPreferences().getString("place", "") // 先将JSON字符串读取出来
        return Gson().fromJson(placeJson, PlaceResponse.Place::class.java) // 通过GSON将JSON字符串解析成Place对象并返回
    }

    // 用于判断是否有数据已被存储
    fun isPlaceSaved() = sharedPreferences().contains("place")

    private fun sharedPreferences() = SunnyWeatherApplication.context.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)
}