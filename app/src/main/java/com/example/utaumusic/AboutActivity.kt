package com.example.utaumusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.utaumusic.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private var _binding: ActivityAboutBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Glide.with(this).load(R.drawable.dimasajisakakurniawan_profil).circleCrop().into(binding.avatar)
        binding.backarrow.setOnClickListener { finish() }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}