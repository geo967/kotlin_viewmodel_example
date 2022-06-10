package com.example.cleanarchitecture.presentation.airwaysDetails


import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.data.repository.AirwaysRepositoryImpl
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.di.AppModule
import com.example.cleanarchitecture.domain.model.Airways
import com.example.cleanarchitecture.domain.useCases.get_airways_details.GetAirwayUseCase
import com.example.cleanarchitecture.presentation.airwaysDetails.components.MainAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
class AirwayDetailsViewModel(repository: AirwaysRepositoryImpl) :ViewModel() {

    //live data
    */
/*private val airwaysList:MutableLiveData<List<Airways>> by lazy {
        MutableLiveData<List<Airways>>()
    }*//*

    private var airwaysList: MutableLiveData<List<Airways>> = MutableLiveData()

   lateinit var postList: List<Airways>


  // private val postList: List<Airways> = GetAirwayUseCase.postList

    companion object {


        lateinit var myAdapter: MainAdapter
        fun callUseCase(context: Context,binding:ActivityMainBinding){
            val rf= AppModule.buildRetrofit()
            GetAirwayUseCase.air(rf,context,binding)
        }
    }
   fun ini(postList:List<Airways>) {
       val myAdapter= MainAdapter()
        airwaysList.value=postList
       Log.d("list123",postList.toString())
       Log.d("list123",airwaysList.toString())
       myAdapter.updateList(postList)
    }
    fun getMutableLiveData(): MutableLiveData<List<Airways>> {
        return airwaysList
    }




}*/

class AirwayDetailsViewModel constructor(private val repository: AirwaysRepositoryImpl)  : ViewModel() {

    val movieList = MutableLiveData<List<Airways>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllAirways() {
        val response = repository.getAllAirways()
        response.enqueue(object : Callback<List<Airways>> {
            override fun onResponse(call: Call<List<Airways>>, response: Response<List<Airways>>) {
                movieList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Airways>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}