package com.example.retrofitdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitdemo.api.JsonPlaceHolderApi
import com.example.retrofitdemo.models.Post
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)
        val call = jsonPlaceHolderApi.getPost()

        call.enqueue(object: Callback<List<Post>>{

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                println("Exception : ${t.message}")
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val posts = response.body()
                    for (item in posts!!) {
                        resultTextView.append(item.toString())
                    }
                }
                else {
                    val responseCode = "Code : ${response.code()}"
                    resultTextView.text = responseCode
                }
            }

        })

    }
}
