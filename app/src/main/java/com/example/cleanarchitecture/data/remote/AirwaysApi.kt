package com.example.cleanarchitecture.data.remote

import com.example.cleanarchitecture.data.remote.dto.AirwaysDto
import com.example.cleanarchitecture.domain.model.Airways
import com.example.cleanarchitecture.presentation.airwaysDetails.components.HttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface AirwaysApi {

    /*@get:GET("v1/8703cae8-f5f2-4682-9bd7-dfcc9eb2e861")
    val posts: Call<List<Airways>>*/

    @GET("v1/8703cae8-f5f2-4682-9bd7-dfcc9eb2e861")
    fun getAllAirways(): Call<List<Airways>>
    companion object {
        var retrofitService: AirwaysApi? = null
        fun getInstance() : AirwaysApi {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                        .baseUrl("https://mocki.io/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(HttpClient.getUnsafeOkHttpClient()!!.build())
                        .build()
                retrofitService = retrofit.create(AirwaysApi::class.java)
            }
            return retrofitService!!
        }
    }
}