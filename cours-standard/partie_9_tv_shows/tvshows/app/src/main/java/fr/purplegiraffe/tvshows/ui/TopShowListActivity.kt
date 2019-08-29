package fr.purplegiraffe.tvshows.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import fr.purplegiraffe.tvshows.R

class TopShowListActivity : ShowListActivity() {

    private fun displayShowsMatching(query: String?) {
        if (query != null && query.length > 2) {
            dataManager.loadShowListWithText(query,this)
        } else {
            dataManager.loadTopShowList(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = getString(R.string.popular_shows)
        dataManager.loadTopShowList(this)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_show_list, menu)

        val searchItem = menu?.findItem(R.id.action_search)


        val searchView = searchItem?.actionView as SearchView

        searchItem?.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                searchView.requestFocus()
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                dataManager.loadTopShowList(this@TopShowListActivity)
                return true
            }
        })

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                displayShowsMatching(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

        })

        return super.onPrepareOptionsMenu(menu)
    }
}
