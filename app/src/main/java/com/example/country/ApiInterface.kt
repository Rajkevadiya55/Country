package com.example.country

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("all")
    fun  getAllCountry(): retrofit2.Call<List<CountryModel>>

}