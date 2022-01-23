package com.example.trizone.webservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NSApiClient {
    companion object {
        var BASE_URL: String = "https://jsonplaceholder.typicode.com/"
        val getClient: NSApiInterface
            get() {

                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()


                return retrofit.create(NSApiInterface::class.java)

            }
    }
}