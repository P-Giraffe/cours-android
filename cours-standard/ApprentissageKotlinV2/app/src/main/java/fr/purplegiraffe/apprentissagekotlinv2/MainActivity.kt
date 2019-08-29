package fr.purplegiraffe.apprentissagekotlinv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val executors = mapOf("Classes" to Classes())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chooserSpinner.adapter = SimpleAdapter(this,executors.keys.)
    }

    fun onExecuteButtonTouched(button: View) {

    }
}
