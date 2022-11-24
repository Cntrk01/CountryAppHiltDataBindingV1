package com.example.countryapphilt.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load

fun ImageView.loadImage(url:String?){
    val placeHolder= createPlaceHolder(this.context)
    this.load(url){
        crossfade(true)
        crossfade(1000)
        placeholder(placeHolder) //placeholder bir fonksiyon.Biz yukarda oluşturdugumuz değişkeni verdikk
    }
}

private fun createPlaceHolder(context: Context): CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth=12f
        centerRadius=40f
        start()
    }
}