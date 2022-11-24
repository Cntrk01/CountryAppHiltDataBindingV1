package com.example.countryapphilt.model

import com.google.gson.annotations.SerializedName

data class EnglishName(
    @SerializedName("official")
    val official:String?,
    @SerializedName("common")
    val common:String?
)
