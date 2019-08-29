package fr.purplegiraffe.slideshow

import android.content.Context
import android.preference.PreferenceManager

class LocalPreferences (context: Context){
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    var slideshowDelay:Int
        get() {
            return sharedPreferences.getInt("slideshowDelay", 3)
        }
        set(value) {
            val finalValue = Math.max(2, Math.min(value, 4))
            sharedPreferences.edit().putInt("slideshowDelay", finalValue).apply()
        }
}