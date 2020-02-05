package com.example.retrofitdemo.models

import com.google.gson.annotations.SerializedName

data class Post(
    val userId : Int,
    val title : String,

    @SerializedName("body")
    val text : String,
    var id : Int? = null)
{

    override fun toString(): String {
        return "ID : ${id?.toString()} \nUser ID : $userId \nTitle : $title \nText : $text \n\n"
    }
}