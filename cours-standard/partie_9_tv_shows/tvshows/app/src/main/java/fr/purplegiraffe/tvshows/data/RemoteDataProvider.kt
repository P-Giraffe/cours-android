package fr.purplegiraffe.tvshows.data

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.net.URLEncoder

class RemoteDataProvider(context: Context) {
    private val requestQueue:RequestQueue = Volley.newRequestQueue(context)
    private val imageBaseUrl:String = "https://image.tmdb.org/t/p/w500/"

    fun getTopTVShows(resultHandler:(showList:List<Show>, error:String?)->Unit) {
        val request = JsonObjectRequest(ApiUrls.Popular.buildURL(), null, Response.Listener {
            val showList = parseShowListResponse(it)
            resultHandler(showList, null)
        }, Response.ErrorListener {
            resultHandler(listOf(),it.localizedMessage)
        })
        requestQueue.add(request)
    }

    fun getTVShowsForQuery(query:String, resultHandler:(showList:List<Show>, error:String?)->Unit) {
        val request = JsonObjectRequest(ApiUrls.SearchShow.addUrlParameter("query", query).buildURL(),null,
            Response.Listener {
                val showList = parseShowListResponse(it)
                resultHandler(showList, null)
            }, Response.ErrorListener {
                resultHandler(listOf(),it.localizedMessage)
            })
        requestQueue.add(request)
    }

    private fun parseShowListResponse(jsonResponseBody: JSONObject) : List<Show> {
        val jsonShowList = jsonResponseBody.getJSONArray("results")
        val showList = mutableListOf<Show>()
        if (jsonShowList != null) {
            for (showIndex in 0 until jsonShowList.length()) {
                val showJson = jsonShowList.getJSONObject(showIndex)
                if (showJson != null) {
                    val showId = showJson.getInt("id")
                    val showTitle = showJson.getString("name")
                    val showDescription = showJson.getString("overview")
                    val imagePath = showJson.getString("backdrop_path")
                    val showImageUrl = imageBaseUrl + imagePath
                    showList.add(Show(showId,showTitle,showDescription,showImageUrl))
                }
            }
        }
        return showList
    }
}

enum class ApiUrls(val path: String) {
    Popular("/tv/popular"),
    SearchShow("/search/tv");

    private val queryParameters = mutableMapOf<String,String>()

    private val apiBaseUrl= "https://api.themoviedb.org/3"
    private val theMovieDBApiKey = "206896aaebf4c97efc6b411932bb61f1"


    fun buildURL(): String {
        addUrlParameter("api_key",theMovieDBApiKey)

        val builder = StringBuilder(apiBaseUrl)
        builder.append(path)

        for (entry in queryParameters) {
            if (builder.contains("?")) {
                builder.append("&")
            } else {
                builder.append("?")
            }
            builder.append(entry.key + "=" + URLEncoder.encode(entry.value, "UTF-8"))
        }

        return builder.toString()
    }

    fun addUrlParameter(key:String,value:String) : ApiUrls {
        queryParameters[key] = value
        return this
    }
}