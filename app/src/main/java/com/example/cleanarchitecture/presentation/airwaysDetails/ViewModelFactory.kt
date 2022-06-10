package com.example.cleanarchitecture.presentation.airwaysDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.data.repository.AirwaysRepositoryImpl

class MyViewModelFactory constructor(private val repository: AirwaysRepositoryImpl): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(AirwayDetailsViewModel::class.java)) {
            AirwayDetailsViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}