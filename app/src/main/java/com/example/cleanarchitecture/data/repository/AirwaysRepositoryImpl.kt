package com.example.cleanarchitecture.data.repository

import com.example.cleanarchitecture.data.remote.AirwaysApi
import com.example.cleanarchitecture.domain.model.Airways
import com.example.cleanarchitecture.domain.repository.AirwaysRepository
import retrofit2.Call

class AirwaysRepositoryImpl(private val retrofitService: AirwaysApi)//AirwaysRepository
{
     fun getAllAirways() =
        retrofitService.getAllAirways()

}