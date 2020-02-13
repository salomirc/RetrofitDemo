package com.example.retrofitdemo.api

import com.example.retrofitdemo.models.Comment
import com.example.retrofitdemo.models.IKnowPumpSearchModel
import com.example.retrofitdemo.models.Post
import com.example.retrofitdemo.models.SeriesTypePump
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface JsonPlaceHolderApi {

//    @GET("posts")
//    fun getPost() : Call<List<Post>>

    @GET("idontknowmypump/frequencies")
    fun getPost() : Call<List<String>>

    @GET("idontknowmypump/brandsByFreq")
    fun getPost(
        @Query("freq") freq: String
    ) : Call<List<String>>

//    @GET("getSeriesAndPumpTypes")
//    fun getPost(
//        @Query("freq") freq: String,
//        @Query("brand") brand: String
//    ) : Call<SeriesTypePump>

//    //override the base URL
//    @GET("https://jsonplaceholder.typicode.com/posts")
//    fun getPost() : Call<List<Post>>

//    //override the base URL
//    @GET("http://193.239.219.51/idontknowmypump/frequencies")
//    fun getPost() : Call<List<String>>

    @GET("posts")
    fun getPostParamUserId(@Query("userId") userId: Int) : Call<List<Post>>

//    @GET("posts")
//    fun getPostParamMulti(
//        @Query("userId") userId: Int,
//        @Query("_sort") sort: String,
//        @Query("_order") order: String
//    ) : Call<List<Post>>

//    @GET("posts")
//    fun getPostParamMulti(
//        @Query("userId") userId: Int,
//        @Query("userId") userId2: Int,
//        @Query("_sort") sort: String,
//        @Query("_order") order: String
//    ) : Call<List<Post>>

//    @GET("posts")
//    fun getPostParamMulti(
//        @Query("userId") userId: List<Int>,
//        @Query("_sort") sort: String,
//        @Query("_order") order: String
//    ) : Call<List<Post>>

    @GET("posts")
    fun getPostParamMulti(@QueryMap parameters: Map<String, String>) : Call<List<Post>>

    @GET
    fun getCommentsURL(@Url url: String) : Call<List<Comment>>

    @GET("posts/{id}/comments")
    fun getComments(@Path("id") postId: Int) : Call<List<Comment>>

    @POST("posts")
    fun createPost(@Body post: Post) : Call<Post>

    @POST("iknowmypump/search")
    fun postIKnowMyPumpSearch(
        @Body body: RequestBody
    ) : Call<List<IKnowPumpSearchModel>>
}