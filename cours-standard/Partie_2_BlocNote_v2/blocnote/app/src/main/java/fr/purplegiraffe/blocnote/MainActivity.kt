package fr.purplegiraffe.blocnote

import android.content.Context
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
        val sharedPreferences = getSharedPreferences("fr.purplegiraffe.blocnote", Context.MODE_PRIVATE)
        fulltext = sharedPreferences.getString("fulltext", "")
        fullTextView.text = fulltext
    }

    fun addButtonTouched(button:View) {
        val userInput = userField.text
        fulltext = "$fulltext\n$userInput"
        val sharedPreferencesEditor = getSharedPreferences("fr.purplegiraffe.blocnote", Context.MODE_PRIVATE).edit()
        sharedPreferencesEditor.putString("fulltext", fulltext)
        sharedPreferencesEditor.apply()
        fullTextView.text = fulltext
        userField.text = null
    }
}

