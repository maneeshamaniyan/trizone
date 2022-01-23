package com.example.trizone.webservice

import com.example.trizone.data.NSDataModel
import retrofit2.Call
import retrofit2.http.GET

interface NSApiInterface {

    @GET("photos")
    fun getPhotos(): Call<List<NSDataModel>>
}