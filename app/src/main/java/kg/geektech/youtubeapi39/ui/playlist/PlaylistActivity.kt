package kg.geektech.youtubeapi39.ui.playlist


import android.content.Intent
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kg.geektech.youtubeapi39.InetActivity
import kg.geektech.youtubeapi39.base.BaseActivity
import kg.geektech.youtubeapi39.data.model.Items
import kg.geektech.youtubeapi39.databinding.ActivityPlaylistBinding

class PlaylistActivity : BaseActivity<PlaylistViewModel, ActivityPlaylistBinding>() {
    private val adapter: Adapter by lazy {
        Adapter(list)
    }
    private  var list = mutableListOf<Items>()

    override val  viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }
    override fun initView() {
        super.initView()
//        checkInet()
        if (isInternetAvailable(this)) {
            viewModel.getPlaylists().observe(this) {
                initAdapter(it.items as MutableList<Items>)
                adapter.setOnClick(object : Adapter.OnCLick {
                    override fun onClicked(position: Items) {
                        Intent(this@PlaylistActivity, PlaylistDetailActivity::class.java).apply {
                            putExtra("idKey", position.id)
                            putExtra("title", position.snippet.title)
                            putExtra("description", position.snippet.description)
                            startActivity(this)
                        }
                    }
                })
            }
        }
        else{
            Intent(this@PlaylistActivity, InetActivity::class.java).apply {
                startActivity(this)
            }
            }
    }

//   this private fun checkInet() {
//        if(intern)
//    }

    private fun initAdapter(list: MutableList<Items>) {
        this.list= list
        binding.rv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@PlaylistActivity.adapter
        }
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
     return ActivityPlaylistBinding.inflate(inflater)
    }

}