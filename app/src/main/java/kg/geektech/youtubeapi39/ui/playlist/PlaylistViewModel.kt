package kg.geektech.youtubeapi39.ui.playlist

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.load.engine.Resource
import kg.geektech.youtubeapi39.BuildConfig.API_KEY
import kg.geektech.youtubeapi39.`object`.Constant
import kg.geektech.youtubeapi39.base.BaseViewModel
import kg.geektech.youtubeapi39.data.model.Playlist
import kg.geektech.youtubeapi39.data.remote.ApiService
import kg.geektech.youtubeapi39.data.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class PlaylistViewModel : BaseViewModel() {

    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun playlists(): LiveData<Playlist> {
        return getPlaylists()
    }

    fun getPlaylists(): LiveData<Playlist> {
        val data = MutableLiveData<Playlist>()

        apiService.getPlaylists(Constant.part, Constant.channelId, API_KEY, Constant.maxResult)
            .enqueue(object : Callback<Playlist> {
                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }
                override fun onFailure(call: Call<Playlist>, t: Throwable) {
                    print(t.stackTrace)
                }

            })
        return data
    }

    }


