package com.example.retrofitdemo.api

import com.example.retrofitdemo.models.Post
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RequestHelper {

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(2, TimeUnit.MINUTES)
        .readTimeout(120, TimeUnit.SECONDS)
        .writeTimeout(120, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val jsonPlaceHolderApi by lazy { retrofit.create(JsonPlaceHolderApi::class.java) }

    suspend fun getPost(): List<Post>?{
        try {
            jsonPlaceHolderApi.getPost().awaitResponse().let { response ->
                if (response.isSuccessful) return response.body()
            }
        }
        catch (e: Exception){
            println("Exception : ${e.message}")
        }
        return null
    }

//    suspend fun getPost(): List<Post>?{
//        try {
//            return jsonPlaceHolderApi.getPost()
//        }
//        catch (e: Exception){
//            println("Exception : ${e.message}")
//        }
//        return null
//    }

//    fun getPost(): List<Post>?{
//        try {
//            jsonPlaceHolderApi.getPost().execute().let { response ->
//                if (response.isSuccessful) return response.body()
//            }
//        }
//        catch (e: Exception){
//            println("Exception : ${e.message}")
//        }
//        return null
//    }
}