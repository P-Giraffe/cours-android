package fr.purplegiraffe.realmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var _realm:Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _realm = Realm.getDefaultInstance()
    }

    fun onAddButtonTouched(button:View) {
        val dogName = ui_nameInput.text.toString()
        if (dogName.isNotEmpty()) {
            val dog = Dog()
            dog.name = dogName

            _realm.beginTransaction()
            _realm.copyToRealm(dog)
            _realm.commitTransaction()

            ui_nameInput.text.clear()
        }
    }

    fun loadDogsFromDataBase() {

    }
}
