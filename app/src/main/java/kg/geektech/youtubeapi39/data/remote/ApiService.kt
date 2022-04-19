package kg.geektech.youtubeapi39.data.remote

import kg.geektech.youtubeapi39.data.model.Playlist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("playlists")
    fun getPlaylists(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String,
        @Query("maxResults") maxResult: Int,
    ): Call<Playlist>
}