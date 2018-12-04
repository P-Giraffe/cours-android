package fr.purplegiraffe.blocnote

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var fulltext = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addButtonTouched(button:View) {
        val userInput = userField.text
        fulltext = "$fulltext\n$userInput"
        fullTextView.text = fulltext
        userField.text = null
    }
}

