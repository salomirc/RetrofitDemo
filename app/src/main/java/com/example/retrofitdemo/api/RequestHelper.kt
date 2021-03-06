package com.example.retrofitdemo.api

import com.example.retrofitdemo.BuildConfig
import com.example.retrofitdemo.models.Comment
import com.example.retrofitdemo.models.IKnowPumpSearchModel
import com.example.retrofitdemo.models.Post
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RequestHelper {

    private val client = OkHttpClient()
    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(2, TimeUnit.MINUTES)
        .readTimeout(120, TimeUnit.SECONDS)
        .writeTimeout(120, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
//        .baseUrl("https://jsonplaceholder.typicode.com/") //must end with one "/" slash
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val jsonPlaceHolderApi: JsonPlaceHolderApi by lazy { retrofit.create(JsonPlaceHolderApi::class.java) }

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

    fun getPost(): List<String>?{
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

    fun getPost(freq: String): List<String>?{
        try {
            jsonPlaceHolderApi.getPost(freq).execute().let { response ->
                if (response.isSuccessful) return response.body()
            }
        }
        catch (e: Exception){
            println("Exception : ${e.message}")
        }
        return null
    }

//        fun getPost(freq: String, brand: String): SeriesTypePump?{
//        try {
//            jsonPlaceHolderApi.getPost(freq, brand).execute().let { response ->
//                if (response.isSuccessful) return response.body()
//            }
//        }
//        catch (e: Exception){
//            println("Exception : ${e.message}")
//        }
//        return null
//    }

    fun getPostUserId(userId: Int): List<Post>?{
        try {
            jsonPlaceHolderApi.getPostParamUserId(userId).execute().let { response ->
                if (response.isSuccessful) return response.body()
            }
        }
        catch (e: Exception){
            println("Exception : ${e.message}")
        }
        return null
    }

//    fun getPostMulti(userId: List<Int>, sort: String, order: String): List<Post>?{
////        try {
////            jsonPlaceHolderApi.getPostParamMulti(userId, sort, order).execute().let { response ->
////                if (response.isSuccessful) return response.body()
////            }
////        }
////        catch (e: Exception){
////            println("Exception : ${e.message}")
////        }
////        return null
////    }

    fun getPostMulti(parameters: Map<String, String>): List<Post>?{
        try {
            jsonPlaceHolderApi.getPostParamMulti(parameters).execute().let { response ->
                if (response.isSuccessful) return response.body()
            }
        }
        catch (e: Exception){
            println("Exception : ${e.message}")
        }
        return null
    }

    fun getComments(postId: Int): List<Comment>?{
        try {
            jsonPlaceHolderApi.getComments(postId).execute().let { response ->
                if (response.isSuccessful) return response.body()
            }
        }
        catch (e: Exception){
            println("Exception : ${e.message}")
        }
        return null
    }

    fun getCommentsURL(url: String): List<Comment>?{
        try {
            jsonPlaceHolderApi.getCommentsURL(url).execute().let { response ->
                if (response.isSuccessful) return response.body()
            }
        }
        catch (e: Exception){
            println("Exception : ${e.message}")
        }
        return null
    }

    fun createPost(post: Post): Post? {
        try {
            jsonPlaceHolderApi.createPost(post).execute().let { response ->
                if (response.isSuccessful) return response.body()
            }
        }
        catch (e: Exception){
            println("Exception : ${e.message}")
        }
        return null
    }

    fun postIKnowMyPumpSearch(parameters: Map<String, String>): List<IKnowPumpSearchModel>? {
        try {
            val requestBody: RequestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM).apply {
                    for (item in parameters){
                        this.addFormDataPart(item.key, item.value)
                    }
                }
                .build()

            jsonPlaceHolderApi.postIKnowMyPumpSearch(requestBody).execute().let { response ->
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

        fun getCommentOkHttp(url: String): List<Comment>?{

            try {
                val request = Request.Builder().url(url).build()
                client.newCall(request).execute().use { response ->
                    if (response.isSuccessful){
                        val sType = object : TypeToken<List<Comment>>() { }.type
                        return Gson().fromJson<List<Comment>>(response.body()!!.string(), sType)
                    }
                }
            }
            catch (e: Exception){
                println("Exception : ${e.message}")
            }
            return null
    }
}