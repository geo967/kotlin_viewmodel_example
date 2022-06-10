package com.example.cleanarchitecture.domain.repository

import com.example.cleanarchitecture.data.remote.AirwaysApi
import com.example.cleanarchitecture.domain.model.Airways
import retrofit2.Call

interface AirwaysRepository{
    fun getAllAirways()
}