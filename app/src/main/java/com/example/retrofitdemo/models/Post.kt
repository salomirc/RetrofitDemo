package com.example.retrofitdemo.models

import com.google.gson.annotations.SerializedName

data class Post(
    val userId : Int,
    val id : Int,
    val title : String,

    @SerializedName("body")
    val text : String)
{

    override fun toString(): String {
        return "ID : $id \nUser ID : $userId \nTitle : $title \nText : $text \n\n"
    }
}