package com.example.cleanarchitecture.domain.useCases.get_airways_details

import android.content.Context
import android.util.Log
import com.example.cleanarchitecture.data.remote.AirwaysApi
import com.example.cleanarchitecture.data.repository.AirwaysRepositoryImpl
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.domain.model.Airways
import com.example.cleanarchitecture.presentation.airwaysDetails.AirwayDetailsViewModel
import com.example.cleanarchitecture.presentation.ui.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class GetAirwayUseCase {/*
    lateinit var postList:List<Airways>
    companion object {

        fun air(rf:Retrofit,context: Context,binding: ActivityMainBinding) {
            val call: Call<List<Airways>>
            val repoImpl=AirwaysRepositoryImpl()
            val vm=AirwayDetailsViewModel(this.repository)

            val api: AirwaysApi = rf.create(AirwaysApi::class.java)
            call=repoImpl.getApiData(api)

            //val call: Call<List<Airways>> = api.posts

            Log.d("qwqw","call out")

            call.enqueue(object : Callback<List<Airways>> {
                override fun onResponse(call: Call<List<Airways>>, response: Response<List<Airways>>) {
                    vm.postList = response.body() as List<Airways>
                    Log.d("qwqw","call in")
                    val post = arrayOfNulls<String>(vm.postList.size)
                    //vm.list = vm.postList
                    vm.ini(vm.postList)
                    for (i in vm.postList.indices) {
                        post[i] = vm.postList[i].aId.toString()
                    }
                    MainActivity.setOrientation(context,binding)
                }

                override fun onFailure(call: Call<List<Airways>>, t: Throwable) {

                }

            })
        }
    }*/
}