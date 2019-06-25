package fr.purplegiraffe.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener({ statusLabel.text = "Vous avez touché le bouton 1" })
        button2.setOnClickListener { buttonTouched:View ->
            statusLabel.text = "Vous avez touché le bouton 2"
            buttonTouched.visibility = View.GONE
        }
    }

//    public fun button2Touched(button: View) {
//
//    }
}
