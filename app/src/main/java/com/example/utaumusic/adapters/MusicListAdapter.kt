package com.example.utaumusic.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.utaumusic.Interface.OnMusicListClickListener
import com.example.utaumusic.databinding.MusicListBinding
import com.example.utaumusic.models.MusicModels

class MusicListAdapter(private var musicList: List<MusicModels>): RecyclerView.Adapter<MusicListAdapter.Viewholder>(){
    inner class Viewholder(val binding: MusicListBinding): RecyclerView.ViewHolder(binding.root)
    private lateinit var onMusicListClickListener: OnMusicListClickListener
    fun onMusicListClickListener(onMusicListClickListener: OnMusicListClickListener){
        this.onMusicListClickListener = onMusicListClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val binding = MusicListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        with(holder) {
            with(musicList[position]){
                Glide.with(itemView.context).load(avatar).circleCrop().into(binding.image)
                binding.title.text = title
                binding.artist.text = artist
                binding.album.text = album
                //list click
                itemView.setOnClickListener { onMusicListClickListener.onMusicListClick(musicList[position]) }
                if (position == musicList.lastIndex){
                    val params = itemView.layoutParams as RecyclerView.LayoutParams
                    params.bottomMargin = 80
                    itemView.layoutParams = params
                } else if (position == 0) {
                    val params = itemView.layoutParams as RecyclerView.LayoutParams
                    params.topMargin = 220
                    itemView.layoutParams = params
                }
            }
        }
    }

    override fun getItemCount() = musicList.size
}