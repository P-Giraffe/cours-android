package fr.purplegiraffe.tvshows.data

import android.content.Context

class ShowsManager(context:Context) {
    private val dataProvider:RemoteDataProvider = RemoteDataProvider(context)
    private val localDataManager:LocalDataManager = LocalDataManager()

    interface Client {
        fun receiveShowList(showList: List<Show>)
    }

    fun loadTopShowList(client:ShowsManager.Client) {
        dataProvider.getTopTVShows { showList, error ->
            client.receiveShowList(showList)
        }
    }

    fun loadMyShowList(client: ShowsManager.Client) {
        client.receiveShowList(localDataManager.getFavoriteShowsList())
    }

    fun loadShowListWithText(text: String, client: Client) {
        dataProvider.getTVShowsForQuery(query = text,resultHandler = { showList, error -> client.receiveShowList(showList) })
    }

    fun addShowToFavorites(show:Show) {
        localDataManager.saveShowAsFavorite(show)
    }

    fun removeShowFromFavorites(show:Show) {
        localDataManager.removeShowFromFavorites(show)
    }

    fun isShowInFavorites(show: Show) : Boolean {
        return localDataManager.isShowInFavorites(show)
    }
}