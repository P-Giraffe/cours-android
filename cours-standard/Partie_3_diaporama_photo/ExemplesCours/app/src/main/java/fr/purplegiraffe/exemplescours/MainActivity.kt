package fr.purplegiraffe.exemplescours

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var clickCount:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        restoreState(savedInstanceState)
        Log.i("ActivityLifecycle", "onCreate")
    }

    fun sushiButtonTouched(sushiButton:View) {
        imageView.setImageResource(R.drawable.sushi)
    }

    fun buttonClick(button:View) {
        clickCount = clickCount + 1
        updateDisplay()
    }

    fun settingsButtonTouched(button:View) {
        val intent = Intent(this, SettingsActivity::class.java)
        intent.putExtra("clickCount", clickCount)
        startActivity(intent)
    }

    fun purpleGiraffeButtonTouched(button:View) {
        val webpage: Uri = Uri.parse("https://www.purplegiraffe.fr")
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun updateDisplay() {
        textView.text = "${clickCount} clic(s)"
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt("clickCount", clickCount)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        restoreState(savedInstanceState)
    }

    private fun restoreState(savedInstanceState: Bundle?) {
        clickCount = savedInstanceState?.getInt("clickCount") ?: 0
        updateDisplay()
    }

    override fun onResume() {
        super.onResume()
        Log.i("ActivityLifecycle", "onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.i("ActivityLifecycle", "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ActivityLifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ActivityLifecycle", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ActivityLifecycle", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ActivityLifecycle", "onDestroy")
    }
}
