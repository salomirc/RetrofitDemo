package com.example.retrofitdemo.api

import com.example.retrofitdemo.models.Post
import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceHolderApi {

    @GET("posts")
    fun getPost() : Call<List<Post>>
}