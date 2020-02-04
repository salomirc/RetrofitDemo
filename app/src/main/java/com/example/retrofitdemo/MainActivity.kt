package com.example.retrofitdemo

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitdemo.api.RequestHelper
import com.example.retrofitdemo.models.Post
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var toggle: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDataButton.setOnClickListener {
            resultTextView.text = ""
            progressBar.visibility = View.VISIBLE
            CoroutineScope(Dispatchers.Main).launch {

                val posts = getPostsVM()

                progressBar.visibility = View.INVISIBLE
                if (posts != null) {
                    for (item in posts) {
                        resultTextView.append(item.toString())
                    }
                }
                else{
                    resultTextView.text = "Network Error"
                }
            }
        }

        toggleButton.setOnClickListener {
            toggle = !toggle
            if(toggle) (it as Button).setBackgroundColor(Color.MAGENTA) else (it as Button).setBackgroundColor(
                Color.BLUE)
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

    private suspend fun getPostsVM() : List<Post>? {
        return RequestHelper.getPost()
    }

//    private suspend fun getPostsVM() : List<Post>? {
//        return withContext(Dispatchers.IO){
//            RequestHelper.getPost()
//        }
//    }
}
