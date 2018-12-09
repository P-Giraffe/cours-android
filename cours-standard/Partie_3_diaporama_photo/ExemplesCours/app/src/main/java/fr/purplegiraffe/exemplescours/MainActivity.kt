package fr.purplegiraffe.exemplescours

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var clickCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("ActivityLifecycle", "onCreate")
    }

    public fun buttonClick(button:View) {
        clickCount = clickCount + 1
        textView.text = "${clickCount} clic(s)"
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
