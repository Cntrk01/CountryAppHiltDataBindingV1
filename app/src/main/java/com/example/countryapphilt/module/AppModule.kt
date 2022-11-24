package com.example.countryapphilt.module

import com.example.countryapphilt.module.Constants.BASE_URL
import com.example.countryapphilt.network.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun url()=BASE_URL

    @Provides
    @Singleton
    fun getRetrofitInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    @Provides
    @Singleton
    fun getApiInstance(retrofit: Retrofit):Api{
        return retrofit.create(Api::class.java)
    }


}