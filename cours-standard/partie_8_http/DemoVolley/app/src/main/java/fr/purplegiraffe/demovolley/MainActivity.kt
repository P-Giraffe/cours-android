package fr.purplegiraffe.demovolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var requestQueue:RequestQueue
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestQueue = Volley.newRequestQueue(this)

        downloadButton.setOnClickListener {
//            val url = urlField.text
//            launchDownloadRequest(url.toString())
            launchJsonObjectRequest("https://jsonplaceholder.typicode.com/todos/1")
//            launchJsonArrayRequest("https://jsonplaceholder.typicode.com/todos")
        }
    }

    fun launchDownloadRequest(url:String){
        val request = StringRequest(Request.Method.GET, url, Response.Listener { body:String ->
            outputView.text = body
        }, Response.ErrorListener {
            outputView.text = "Error"
        })

        outputView.text = "Chargement..."
        requestQueue.add(request)
    }

    fun launchJsonObjectRequest(url:String) {
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener {taskObject ->
            outputView.text = taskObject.getString("title")
        }, Response.ErrorListener {
            outputView.text = "Error"
        })
        requestQueue.add(jsonObjectRequest)
    }

    fun launchJsonArrayRequest(url:String) {

    }
}
