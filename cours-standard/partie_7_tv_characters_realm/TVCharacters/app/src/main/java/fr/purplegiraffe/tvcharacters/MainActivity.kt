package fr.purplegiraffe.tvcharacters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ui_characterList.adapter = CharactersAdapter()
        ui_characterList.layoutManager = LinearLayoutManager(this)
    }
}
