package fr.purplegiraffe.slideshow

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_slideshow.*

class SlideshowActivity : AppCompatActivity() {
    val photoList = arrayOf(R.drawable.sushi, R.drawable.chat1, R.drawable.chien1, R.drawable.chat2, R.drawable.chien2, R.drawable.chat3)
    var currentPhotoIndex = 0
    var countDownTimer:CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slideshow)
    }

    override fun onResume() {
        super.onResume()
        startSlideshow()
    }

    override fun onPause() {
        super.onPause()
        stopSlideshow()
    }

    fun previousButtonTouched(button:View) {
        stopSlideshow()
        currentPhotoIndex = currentPhotoIndex - 1
        if (currentPhotoIndex < 0) {
            currentPhotoIndex = photoList.size - 1
        }
        imageView.setImageResource(photoList[currentPhotoIndex])
        startSlideshow()
    }

    fun nextButtonTouched(button: View) {
        stopSlideshow()
        showNextPhoto()
        startSlideshow()
    }

    fun stopSlideshow() {
        countDownTimer?.cancel()
        countDownTimer = null
    }

    fun startSlideshow() {
        val delay = (LocalPreferences(this).slideshowDelay * 1000).toLong()
        countDownTimer = object : CountDownTimer(delay,delay) {
            override fun onFinish() {
                showNextPhoto()
                startSlideshow()
            }

            override fun onTick(millisUntilFinished: Long) { }
        }
        countDownTimer?.start()
    }

    fun showNextPhoto() {
        currentPhotoIndex = currentPhotoIndex + 1
        if (currentPhotoIndex >= photoList.size) {
            currentPhotoIndex = 0
        }
        imageView.setImageResource(photoList[currentPhotoIndex])
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt("currentPhotoIndex", currentPhotoIndex)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        currentPhotoIndex = savedInstanceState?.getInt("currentPhotoIndex") ?: 0
        imageView.setImageResource(photoList[currentPhotoIndex])
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                R.id.settings_button -> displaySettings()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun displaySettings() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}
