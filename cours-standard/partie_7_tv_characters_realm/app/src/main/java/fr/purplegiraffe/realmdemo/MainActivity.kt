package fr.purplegiraffe.realmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    lateinit var _realm:Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _realm = Realm.getDefaultInstance()
        loadDogsFromDataBase()
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

            loadDogsFromDataBase()
        }
    }

    fun loadDogsFromDataBase() {
        val dogList = _realm.where(Dog::class.java).findAll()

        val listBuilder = StringBuilder("Liste de chiens :\n")
        for (dog in dogList) {
            listBuilder.append("- ${dog.name}\n")
        }

        ui_dataView.text = listBuilder.toString()
    }
}
