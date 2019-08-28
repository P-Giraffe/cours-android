package fr.purplegiraffe.tvshows.data

import io.realm.Realm
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

class LocalDataManager() {
    val realm = Realm.getDefaultInstance()

    fun saveShowAsFavorite(show: Show) {
        if (isShowInFavorites(show) == false) {
            val newFavorite = ShowFavorite()
            newFavorite.id = show.id
            newFavorite.title = show.title
            newFavorite.description = show.description
            newFavorite.imageUrl = show.imageUrl
            realm.beginTransaction()
            realm.copyToRealm(newFavorite)
            realm.commitTransaction()
        }
    }

    fun removeShowFromFavorites(show: Show) {
        val showFavoriteToRemove = realm.where(ShowFavorite::class.java).equalTo("id",show.id).findFirst()
        if (showFavoriteToRemove != null) {
            realm.beginTransaction()
            showFavoriteToRemove.deleteFromRealm()
            realm.commitTransaction()
        }
    }

    fun getFavoriteShowsList() : List<Show> {
         return realm.where(ShowFavorite::class.java).findAll().toList().map { showFavorite -> Show(showFavorite.id, showFavorite.title, showFavorite.description, showFavorite.imageUrl) }
    }

    fun isShowInFavorites(show: Show) : Boolean {
        return realm.where(ShowFavorite::class.java).equalTo("id",show.id).count() > 0
    }
}

@RealmClass
open class ShowFavorite : RealmObject() {
    @PrimaryKey var id = 0
    var title = ""
    var imageUrl = ""
    var description = ""
}