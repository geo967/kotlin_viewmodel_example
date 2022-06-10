package com.example.cleanarchitecture.presentation.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.data.remote.AirwaysApi
import com.example.cleanarchitecture.data.repository.AirwaysRepositoryImpl
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.di.AppModule
import com.example.cleanarchitecture.domain.useCases.get_airways_details.GetAirwayUseCase

import com.example.cleanarchitecture.presentation.airwaysDetails.AirwayDetailsViewModel
import com.example.cleanarchitecture.presentation.airwaysDetails.MyViewModelFactory
import com.example.cleanarchitecture.presentation.airwaysDetails.components.MainAdapter

class MainActivity : AppCompatActivity() {
    lateinit var airwayDetailsViewModel: AirwayDetailsViewModel
    lateinit var binding:ActivityMainBinding
    private val retrofitService = AirwaysApi.getInstance()
    private val adapter = MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

       /* val rf=AppModule.buildRetrofit()
        GetAirwayUseCase.air(rf,this,binding)*/


    /*    airwayDetailsViewModel=ViewModelProvider(this)[AirwayDetailsViewModel::class.java]
        AirwayDetailsViewModel.callUseCase(this,binding)
        Log.d("vm","here")
        airwayDetailsViewModel.getMutableLiveData().observe(this, Observer {
            Log.d("vm","here")
            adapter.updateList(it)

        })*/
        airwayDetailsViewModel = ViewModelProvider(this, MyViewModelFactory(AirwaysRepositoryImpl(retrofitService))).get(AirwayDetailsViewModel::class.java)
        val layoutManager = GridLayoutManager(this, 2)
        layoutManager.orientation = RecyclerView.VERTICAL
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        airwayDetailsViewModel.movieList.observe(this, Observer {
            adapter.updateList(it)
        })

        airwayDetailsViewModel.errorMessage.observe(this, Observer {

        })
        airwayDetailsViewModel.getAllAirways()

    }
   /* companion object {
        fun setOrientation(context: Context, binding: ActivityMainBinding) {
            val layoutManager = GridLayoutManager(context, 2)
            layoutManager.orientation = RecyclerView.VERTICAL

            binding.recyclerView.setHasFixedSize(true)
            binding.recyclerView.layoutManager = layoutManager
            AirwayDetailsViewModel.myAdapter=MainAdapter()
            binding.recyclerView.adapter = AirwayDetailsViewModel.myAdapter
        }
    }*/
}