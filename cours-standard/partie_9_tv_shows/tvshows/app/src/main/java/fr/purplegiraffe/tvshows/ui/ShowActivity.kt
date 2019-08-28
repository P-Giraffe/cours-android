package fr.purplegiraffe.tvshows.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import fr.purplegiraffe.tvshows.R
import fr.purplegiraffe.tvshows.data.Show
import fr.purplegiraffe.tvshows.data.ShowsManager
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity() {
    private lateinit var showsManager:ShowsManager
    private lateinit var show:Show

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        show = intent.getSerializableExtra("show") as Show
        showsManager = ShowsManager(this)
        updateFavoriteButtonTitle()
        titleView.text = show.title
        descriptionView.text = show.description
        Glide.with(this).load(show.imageUrl).into(imageView)

    }

    private fun updateFavoriteButtonTitle() {
        if (showsManager.isShowInFavorites(show)) {
            favoritesButton.text = getString(R.string.remove_from_favorites)
        } else {
            favoritesButton.text = getString(R.string.add_to_favorites)
        }
    }


    fun changeFavoritesStatusButtonTouched(button:View) {
        if (showsManager.isShowInFavorites(show)) {
            showsManager.removeShowFromFavorites(show)
        } else {
            showsManager.addShowToFavorites(show)
        }
        updateFavoriteButtonTitle()
    }
}
