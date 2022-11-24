package com.example.countryapphilt.model


import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("common")
    val common: String?,
//    @SerializedName("nativeName")
//    val nativeName: NativeName<Any>?,
    @SerializedName("official")
    val official: String?
)