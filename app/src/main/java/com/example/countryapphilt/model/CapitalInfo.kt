package com.example.countryapphilt.model


import com.google.gson.annotations.SerializedName

data class CapitalInfo(
    @SerializedName("latlng")
    val latlng: List<Double?>? //0.eleman lat 1.eleman long
)