package fr.purplegiraffe.demovolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val requestQueue = Volley.newRequestQueue(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        downloadButton.setOnClickListener {
            val url = urlField.text
            launchDownloadRequest(url.toString())
        }
    }

    fun launchDownloadRequest(url:String){

    }
}
