package com.example.countryapphilt.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class DataList(
    @SerializedName("capital")
    val capital: ArrayList<String>?,
    @SerializedName("capitalInfo")
    val capitalInfo: @RawValue CapitalInfo?,
    @SerializedName("coatOfArms")
    val coatOfArms: @RawValue CoatOfArms?,
    @SerializedName("continents")
    val continents: List<String>?,
    @SerializedName("latlng")
    val latlng: ArrayList<Double>?,
    @SerializedName("maps")
    val maps: @RawValue Maps?,
    @SerializedName("name")
    val name: @RawValue Name?,
    @SerializedName("population")
    val population: Double?,
    @SerializedName("region")
    val region: String?,
    @SerializedName("startOfWeek")
    val startOfWeek: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("subregion")
    val subregion: String?,
    @SerializedName("timezones")
    val timezones: List<String>?,
    @SerializedName("translations")
    val translations: @RawValue Translations?,
    @SerializedName("flags")
    val flags: @RawValue Flags,



) : Parcelable
