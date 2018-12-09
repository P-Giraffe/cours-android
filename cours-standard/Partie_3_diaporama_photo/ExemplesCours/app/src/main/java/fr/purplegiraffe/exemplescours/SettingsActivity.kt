package fr.purplegiraffe.exemplescours

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val clickCount = intent.getIntExtra("clickCount", 0)
        clickCountTextView.text = "J'ai reçu ${clickCount} clic(s)"
    }
}
