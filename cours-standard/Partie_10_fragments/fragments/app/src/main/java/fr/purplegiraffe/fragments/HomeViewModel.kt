package fr.purplegiraffe.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    fun startLoadingShow() {
        val show = Show(name = "Silicon Valley", category = "Comedy")
        loadedShow.value = show
    }

    val loadedShow = MutableLiveData<Show>()
}