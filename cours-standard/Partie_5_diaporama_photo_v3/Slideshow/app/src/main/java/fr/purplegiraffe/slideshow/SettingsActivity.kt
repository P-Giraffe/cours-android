package fr.purplegiraffe.slideshow

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        delaySeekbar.setOnSeekBarChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        LocalPreferences(this).slideshowDelay = delaySeekbar.progress
    }

    override fun onStart() {
        super.onStart()
        delaySeekbar.progress = LocalPreferences(this).slideshowDelay
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        delayText.text = "$progress s"
        LocalPreferences(this).slideshowDelay = progress
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}
