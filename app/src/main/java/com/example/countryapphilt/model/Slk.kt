package com.example.countryapphilt.model

import com.google.gson.annotations.SerializedName

data class Slk (
    @SerializedName("common")
    val common: String?,
    @SerializedName("official")
    val official: String?
)
