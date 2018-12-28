package fr.purplegiraffe.countdowntimerexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var countDownTimer : CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun beginLaunchButtonTouched(button: View) {
        if (countDownTimer != null) {
            countDownTimer?.cancel()
            countDownTimer = null
            launchStatus.text = "Séquence de décollage annulée"
        } else {
            countDownTimer = object : CountDownTimer(5000, 1000) {
                override fun onFinish() {
                    launchStatus.text = "Décollage!!!!"
                }

                override fun onTick(millisUntilFinished: Long) {
                    launchStatus.text = "${millisUntilFinished / 1000}..."
                }
            }
            countDownTimer?.start()
        }
    }
}
