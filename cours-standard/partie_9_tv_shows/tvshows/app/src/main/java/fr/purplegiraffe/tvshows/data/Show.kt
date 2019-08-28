package fr.purplegiraffe.tvshows.data

import java.io.Serializable

data class Show(var id:Int, var title:String, var description:String, var imageUrl:String) : Serializable
