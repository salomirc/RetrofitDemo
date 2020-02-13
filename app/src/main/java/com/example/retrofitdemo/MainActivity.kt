package com.example.retrofitdemo

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitdemo.api.RequestHelper
import com.example.retrofitdemo.models.Comment
import com.example.retrofitdemo.models.Post
import com.example.retrofitdemo.models.SeriesTypePump
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

//                  val results: String? = null
                val results =  withContext(Dispatchers.IO){
                    RequestHelper.postIKnowMyPumpSearch(mapOf("searchString" to "XYLEM"))
                }
//                val objectResult = getPostsVM()
//                val objectResult = getPostsVM("50")
//                val results = getCommentsVM(3)
//                val results = getCommentsVM(3)
//                val results = getPostUserIdVM(4)
//                val results = getPostMulti(mapOf("userId" to "1", "_sort" to "id", "_order" to "desc"))
//                val results = getCommentsUrlVM("post/3/comments")
//                val results = getCommentsUrlVM("https://jsonplaceholder.typicode.com/post/3/comments")
//                val results = getPostMulti(4, "null", "null")
//                val results = getCommentOkHttp("https://jsonplaceholder.typicode.com/posts/3/comments")


                val objectResult = null
//                val objectResult = createPost(Post(23, "New Title", "New Text"))

                progressBar.visibility = View.INVISIBLE
                if (results != null) {
                    val sb: StringBuilder = StringBuilder()
                    for (item in results) {
                        sb.append(item.toString())
                    }
                    resultTextView.text = sb.toString()
//                    resultTextView.text = results[0].toString()
                }
                else if (objectResult != null){
                    resultTextView.text = objectResult.toString()
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

//    private suspend fun getPostsVM() : List<Post>? {
//        return withContext(Dispatchers.IO){
//            RequestHelper.getPost()
//        }
//    }

    private suspend fun getPostsVM() : List<String>? {
        return withContext(Dispatchers.IO){
            RequestHelper.getPost()
        }
    }

    private suspend fun getPostsVM(freq: String) : List<String>? {
        return withContext(Dispatchers.IO){
            RequestHelper.getPost(freq)
        }
    }

    private suspend fun getPostUserIdVM(id: Int) : List<Post>? {
        return withContext(Dispatchers.IO){
            RequestHelper.getPostUserId(id)
        }
    }

//    private suspend fun getPostMulti(userId: List<Int>, sort: String, order: String) : List<Post>? {
//        return withContext(Dispatchers.IO){
//            RequestHelper.getPostMulti(userId, sort, order)
//        }
//    }

    private suspend fun getPostMulti(parameters: Map<String, String>) : List<Post>? {
        return withContext(Dispatchers.IO){
            RequestHelper.getPostMulti(parameters)
        }
    }

    private suspend fun getCommentsVM(postId: Int) : List<Comment>? {
        return withContext(Dispatchers.IO){
            RequestHelper.getComments(postId)
        }
    }

    private suspend fun getCommentsUrlVM(url: String) : List<Comment>? {
        return withContext(Dispatchers.IO){
            RequestHelper.getCommentsURL(url)
        }
    }

    private suspend fun getCommentOkHttp(urlString: String) : List<Comment>? {
        return withContext(Dispatchers.IO){
            RequestHelper.getCommentOkHttp(urlString)
        }
    }

    private suspend fun createPost(post: Post) : Post? {
        return withContext(Dispatchers.IO){
            RequestHelper.createPost(post)
        }
    }
}
