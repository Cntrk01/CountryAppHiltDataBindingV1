package com.example.countryapphilt.network

import com.example.countryapphilt.model.DataList
import com.example.countryapphilt.module.Constants.LAST_URL
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET(LAST_URL)
    suspend fun getDataFromApi(): Response<List<DataList>>
}