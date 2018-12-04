package fr.purplegiraffe.demokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var fullname = "John Doe"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goButtonTouched(button:View) {
        val firstname = firstnameField.text
        val lastname = lastnameField.text
        val champTextePrenom = firstnameField
        champTextePrenom.append("Bazinga!")
        fullname = "${firstname} ${lastname}"
        welcomeUser()
    }

    fun clearButtonTouched(button:View) {
        welcomeUser()
    }

    fun welcomeUser() {
        resultView.text = "Bonjour ${fullname}"
        firstnameField.setText("")
        lastnameField.setText("")
    }
}
