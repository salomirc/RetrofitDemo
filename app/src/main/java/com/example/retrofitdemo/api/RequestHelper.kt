package com.example.retrofitdemo.api

import com.example.retrofitdemo.models.Post
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestHelper {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val jsonPlaceHolderApi by lazy { retrofit.create(JsonPlaceHolderApi::class.java) }

    fun getPost(): List<Post>?{

        try {
            jsonPlaceHolderApi.getPost().execute().let { response ->
                if (response.isSuccessful) return response.body()
            }
        }
        catch (e: Exception){
            println("Exception : ${e.message}")
        }
        return null
    }
}