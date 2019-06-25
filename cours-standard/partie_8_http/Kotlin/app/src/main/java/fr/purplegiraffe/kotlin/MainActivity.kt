package fr.purplegiraffe.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val calculatedValue:Int by lazy {
        Log.i("LAZY", "Calcul de la valeur en cours")

        var bigValue = 1
        for (i in 1..10) {
            bigValue *= i
        }
        bigValue
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener({ statusLabel.text = "Vous avez touché le bouton 1" })
        button2.setOnClickListener { buttonTouched:View ->
            statusLabel.text = "Vous avez touché le bouton 2"
            buttonTouched.visibility = View.GONE
        }

        Log.i("LAZY", "$calculatedValue")
        Log.i("LAZY", "$calculatedValue")
    }

//    public fun button2Touched(button: View) {
//
//    }
}
