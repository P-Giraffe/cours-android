package fr.purplegiraffe.blocnote

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var fulltext = ""
    val SETTINGS_FILE_NAME = "fr.purplegiraffe.blocnote"
    val FULLTEXT_SETTINGS_KEY = "fulltext"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences(SETTINGS_FILE_NAME, Context.MODE_PRIVATE)
        fulltext = sharedPreferences.getString(FULLTEXT_SETTINGS_KEY, "")
        fullTextView.text = fulltext
    }

    fun addButtonTouched(button:View) {
        val userInput = userField.text
        fulltext = "$fulltext\n$userInput"
        saveTextToDB()
        fullTextView.text = fulltext
        userField.text = null
    }

    fun saveTextToDB() {
        val sharedPreferencesEditor = getSharedPreferences(SETTINGS_FILE_NAME, Context.MODE_PRIVATE).edit()
        sharedPreferencesEditor.putString(FULLTEXT_SETTINGS_KEY, fulltext)
        sharedPreferencesEditor.apply()
    }
}

