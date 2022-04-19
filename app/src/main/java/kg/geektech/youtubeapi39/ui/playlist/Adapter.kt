package kg.geektech.youtubeapi39.ui.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.geektech.youtubeapi39.data.model.Items
import kg.geektech.youtubeapi39.databinding.ItemBinding


class Adapter(private var list: List<Items>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private lateinit var onCLick : OnCLick

    fun setOnClick(onCLick: OnCLick) {
        this.onCLick = onCLick
    }

    inner class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item:Items ) {
            Glide.with(binding.imgV).load(item.snippet.thumbnails.default.url).into(binding.imgV)
            binding.text1.text = item.snippet.title
            binding.text2.text = item.contentDetails.itemCount.toString()
            itemView.setOnClickListener {
                onCLick.onClicked(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface OnCLick {
        fun onClicked(position: Items)
    }
}