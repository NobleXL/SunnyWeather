package com.sunnyweather.android.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweather.android.logic.Repository
import com.sunnyweather.android.logic.model.PlaceResponse

class WeatherViewModel : ViewModel() {

    private val locationLiveData = MutableLiveData<PlaceResponse.Location>()

    var locationLng = ""

    var locationLat = ""

    var placeName = ""

    // 使用Transformations.switchMap()来观察locationLiveData
    val weatherLiveData = Transformations.switchMap(locationLiveData) { location ->
        Repository.refreshWeather(location.lng, location.lat)
    }
    // 刷新天气信息
    fun refreshWeather(lng: String, lat: String) {
        locationLiveData.value = PlaceResponse.Location(lng, lat)
    }

    fun savePlace(place: PlaceResponse.Place) = Repository.savePlace(place)

    fun getSavedPlace() = Repository.getSacedPlace()
    fun isPlaceSaved() = Repository.isPlaceSaved()
}