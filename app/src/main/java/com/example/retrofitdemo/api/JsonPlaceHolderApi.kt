package com.example.retrofitdemo.api

import com.example.retrofitdemo.models.Comment
import com.example.retrofitdemo.models.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceHolderApi {

    @GET("posts")
    fun getPost() : Call<List<Post>>

    @GET("posts/{id}/comments")
    fun getComments(@Path("id") postId: Int) : Call<List<Comment>>
}