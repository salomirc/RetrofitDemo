package com.example.retrofitdemo

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitdemo.api.RequestHelper
import com.example.retrofitdemo.models.Comment
import com.example.retrofitdemo.models.Post
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private var toggle: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDataButton.setOnClickListener {
            resultTextView.text = ""
            progressBar.visibility = View.VISIBLE
            CoroutineScope(Dispatchers.Main).launch {

//                val results = getPostsVM()
//                val results = getCommentsVM(3)
                val results = getCommentsVM(3)
//                val results = getCommentOkHttp("https://jsonplaceholder.typicode.com/posts/3/comments")

                progressBar.visibility = View.INVISIBLE
                if (results != null) {
//                    val sb: StringBuilder = StringBuilder()
//                    for (item in results) {
//                        sb.append(item.toString())
//                    }
//                    resultTextView.text = sb.toString()
                    resultTextView.text = results[0].toString()
                }
                else{
                    resultTextView.text = "Network Error"
                }
            }
        }

//        getDataButton.setOnClickListener {
//            resultTextView.text = ""
//            val call = RequestHelper.jsonPlaceHolderApi.getComments(3)
//
//            call.enqueue(object: Callback<List<Comment>> {
//
//                override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
//                    println("Exception : ${t.message}")
//                }
//
//                override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
//                    if (response.isSuccessful) {
//                        val posts = response.body()
//                        for (item in posts!!) {
//                            resultTextView.append(item.toString())
//                        }
//                    }
//                    else {
//                        val responseCode = "Code : ${response.code()}"
//                        resultTextView.text = responseCode
//                    }
//                }
//
//            })
//        }



        toggleButton.setOnClickListener {
            toggle = !toggle
            if(toggle) (it as Button).setBackgroundColor(Color.MAGENTA) else (it as Button).setBackgroundColor(
                Color.BLUE)
        }

    }

//    private suspend fun getPostsVM() : List<Post>? {
//        return RequestHelper.getPost()
//    }
//
//    private suspend fun getCommentsVM(postId: Int) : List<Comment>? {
//        return RequestHelper.getComments(postId)
//    }

    private suspend fun getPostsVM() : List<Post>? {
        return withContext(Dispatchers.IO){
            RequestHelper.getPost()
        }
    }

    private suspend fun getCommentsVM(postId: Int) : List<Comment>? {
        return withContext(Dispatchers.IO){
            RequestHelper.getComments(postId)
        }
    }

    private suspend fun getCommentOkHttp(urlString: String) : List<Comment>? {
        return withContext(Dispatchers.IO){
            RequestHelper.getCommentOkHttp(urlString)
        }
    }
}
