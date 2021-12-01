package com.changers.thedogapi.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.changers.thedogapi.Breed
import com.changers.thedogapi.api.BreedApiService
import com.changers.thedogapi.api.retrofit
import retrofit2.Call
import retrofit2.Response

class MainViewModel : ViewModel() {

    val _selectedItem = MutableLiveData<Breed>()
    val person:LiveData<Breed> = _selectedItem

    fun setSelectItem(item:Breed){
        _selectedItem.value = item
    }
    private val _response: MutableLiveData<List<Breed>> = MutableLiveData<List<Breed>>()
    val breed: LiveData<List<Breed>> = _response

    init {
        getResponseFromAsteroidApi()
    }


    private fun getResponseFromAsteroidApi() {

        val service = retrofit.create(BreedApiService::class.java)

        val countryRequest = service.getBreeds()

        countryRequest.enqueue(object : retrofit2.Callback<List<Breed>> {

            override fun onResponse(call: Call<List<Breed>>, response: Response<List<Breed>>) {
                _response.value = response.body()
            }

            override fun onFailure(call: Call<List<Breed>>, t: Throwable) {
                Log.d(TAG, "Failure {${t.message}}")
            }

        })
    }
    companion object{
        val TAG = "MainViewModel"
    }
}