package com.example.utaumusic

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.RequiresApi
import com.example.utaumusic.databinding.ActivityDetailBinding
import com.example.utaumusic.models.MusicModels

class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val data = intent.getParcelableExtra(data, MusicModels::class.java)
        val data = intent.getParcelableExtra<MusicModels>(data) as MusicModels
        binding.image.setImageResource(data.avatar!!)
        binding.title.text = data.title
        binding.artist.text = data.artist
        binding.albumname.text = data.album
        binding.desccontent.text = data.desc
        binding.backarrow.setOnClickListener { finish() }
    }

    companion object{
        const val data = "Data"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}