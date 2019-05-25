package fr.purplegiraffe.realmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
