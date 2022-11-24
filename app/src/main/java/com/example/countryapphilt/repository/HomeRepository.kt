package com.example.countryapphilt.repository

import com.example.countryapphilt.network.Api
import javax.inject.Inject

class HomeRepository @Inject
    constructor(private val api: Api) {
    suspend fun getData()=api.getDataFromApi()

}