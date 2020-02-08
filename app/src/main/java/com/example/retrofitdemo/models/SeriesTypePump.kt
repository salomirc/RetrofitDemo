package com.example.retrofitdemo.models

import com.google.gson.annotations.SerializedName

data class SeriesTypePump (

    @SerializedName("series") val series : List<Int>,
    @SerializedName("pumpTypes") val pumpTypes : List<String>
)
{
    override fun toString(): String {
        return "Series : $series\nType : $pumpTypes \n\n"
    }
}