package fr.purplegiraffe.demokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var fullname = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goButtonTouched(button:View) {
        val firstname = firstnameField.text
        val lastname = lastnameField.text
        if (firstname.length > 0 && lastname.length > 0) {
            fullname = "${firstname} ${lastname}"
        } else {
            fullname = ""
        }
        welcomeUser()
    }

    fun clearButtonTouched(button:View) {
        fullname = ""
        welcomeUser()
    }

    fun welcomeUser() {
        if (fullname.length > 0) {
            resultView.text = "Bonjour ${fullname}"
        } else {
            resultView.text = "Saisissez d'abord votre nom et votre prénom puis appuyez sur 'Go'"
        }
        firstnameField.setText("")
        lastnameField.setText("")
    }
}
