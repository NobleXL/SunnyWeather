package com.sunnyweather.android.logic.model

/**
 * 将realtime和Daily对象进行封装
 */
data class Weather(val realtime: RealtimeResponse.Realtime, val daily: DailyResponse.Daily) {
}