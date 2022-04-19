package kg.geektech.youtubeapi39

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kg.geektech.youtubeapi39.data.model.Items
import kg.geektech.youtubeapi39.ui.playlist.Adapter
import kg.geektech.youtubeapi39.ui.playlist.PlaylistActivity
import kg.geektech.youtubeapi39.ui.playlist.PlaylistDetailActivity
import kg.geektech.youtubeapi39.ui.playlist.isInternetAvailable

class InetActivity : AppCompatActivity() {
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inet)
        button = findViewById(R.id.btn)
        button.setOnClickListener {
            if (isInternetAvailable(this)) {
                Intent(this, PlaylistActivity::class.java).apply {
                    startActivity(this)
            }

            }
        }

    }


}