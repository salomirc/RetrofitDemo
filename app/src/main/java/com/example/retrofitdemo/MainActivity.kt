package com.example.retrofitdemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitdemo.api.RequestHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar.visibility = View.VISIBLE
        CoroutineScope(Dispatchers.IO).launch {
            val posts = RequestHelper.getPost()
            withContext(Dispatchers.Main){
                progressBar.visibility = View.INVISIBLE
                for (item in posts!!) {
                        resultTextView.append(item.toString())
                    }

            }
        }

//        call.enqueue(object: Callback<List<Post>>{
////
////            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
////                println("Exception : ${t.message}")
////            }
////
////            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
////                if (response.isSuccessful) {
////                    val posts = response.body()
////                    for (item in posts!!) {
////                        resultTextView.append(item.toString())
////                    }
////                }
////                else {
////                    val responseCode = "Code : ${response.code()}"
////                    resultTextView.text = responseCode
////                }
////            }
////
////        })

    }
}
