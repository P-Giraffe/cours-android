package fr.purplegiraffe.tvshows.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import fr.purplegiraffe.tvshows.R
import fr.purplegiraffe.tvshows.data.Show
import fr.purplegiraffe.tvshows.data.ShowsManager
import kotlinx.android.synthetic.main.activity_show_list.*

class MyShowListActivity : ShowListActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = getString(R.string.my_favorites)
    }

    override fun onResume() {
        super.onResume()
        dataManager.loadMyShowList(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_show_list, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                R.id.add_show -> {
                    goToTopRatedShowList()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun goToTopRatedShowList() {
        val intent = Intent(this,TopShowListActivity::class.java)
        startActivity(intent)
    }
}
