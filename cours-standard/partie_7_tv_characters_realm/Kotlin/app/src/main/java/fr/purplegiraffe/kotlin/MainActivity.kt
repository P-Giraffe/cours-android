package fr.purplegiraffe.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    lateinit var person:Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        person = Person("Arya Stark")
        val p2 = Person()
        createLongString()
    }

    fun onButtonClick(button: View) {
        person.sayHello()
    }

    fun createLongString() {
        val allTextBuilder = StringBuilder("Hello ")
        for (i in 0..100) {
            allTextBuilder.append(", ")
            allTextBuilder.append(i)
        }

        print(allTextBuilder.toString())
    }
}
