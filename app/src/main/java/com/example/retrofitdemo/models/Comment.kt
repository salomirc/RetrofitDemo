package com.example.retrofitdemo.models

import com.google.gson.annotations.SerializedName

data class Comment(
    val postId : Int,
    val id : Int,
    val name : String,
    val email : String,

    @SerializedName("body")
    val text : String)
{

    override fun toString(): String {
        return "ID : $id \nUser ID : $postId \nTitle : $name \nEmail : $email\nText : $text \n\n"
    }
}