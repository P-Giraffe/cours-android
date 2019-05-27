package fr.purplegiraffe.tvcharacters

import android.app.Application
import io.realm.Realm

class TVCharactersApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}