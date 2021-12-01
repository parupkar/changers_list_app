package com.changers.thedogapi.api

import com.changers.thedogapi.Breed
import com.changers.thedogapi.Constants.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

interface BreedApiService{
    @GET("breeds")
    fun getBreeds():Call<List<Breed>>
}

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

object BreedApi{
    val breedApiService:BreedApiService by lazy{
        retrofit.create(BreedApiService::class.java)
    }
}