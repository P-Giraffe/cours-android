package fr.purplegiraffe.slideshow

import android.content.Context
import kotlin.math.max
import kotlin.math.min

class LocalPreferences (context: Context){
    val sharedPreferences = context.getSharedPreferences("fr.purplegiraffe.slideshow", Context.MODE_PRIVATE)

    var slideshowDelay:Int
        get() {
            return sharedPreferences.getInt("slideshowDelay", 3)
        }
        set(value) {
            val finalValue = max(2, min(value, 4))
            sharedPreferences.edit().putInt("slideshowDelay", finalValue).apply()
        }
}