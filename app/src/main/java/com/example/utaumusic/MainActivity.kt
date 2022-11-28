package com.example.utaumusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.utaumusic.Interface.OnMusicListClickListener
import com.example.utaumusic.adapters.MusicListAdapter
import com.example.utaumusic.databinding.ActivityMainBinding
import com.example.utaumusic.models.MusicModels

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val musicList: ArrayList<MusicModels> = ArrayList()
    private var adapter: RecyclerView.Adapter<MusicListAdapter.Viewholder>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addData()
        adapter = MusicListAdapter(musicList)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.musicList.adapter = adapter
        binding.musicList.layoutManager = layoutManager

        //interface onMusicClickListener
        (adapter as MusicListAdapter).onMusicListClickListener(object: OnMusicListClickListener{
            override fun onMusicListClick(data: MusicModels) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.data,data)
                startActivity(intent)
            }
        })

        //move to about page
        binding.aboutPage.setOnClickListener { startActivity(Intent(this, AboutActivity::class.java)) }
    }

    private fun addData(){
        musicList.add(MusicModels(R.drawable.aimer_zankyosanka, getString(R.string.aimer_music),getString(R.string.aimer),getString(R.string.aimer_album),getString(R.string.aimer_desc)))
        musicList.add(MusicModels(R.drawable.lisa_gurenge, getString(R.string.lisa_music),getString(R.string.lisa),getString(R.string.lisa_album),getString(R.string.lisa_desc)))
        musicList.add(MusicModels(R.drawable.lilasikuta_omokage, getString(R.string.lilas_music),getString(R.string.lilas),getString(R.string.lilas_album),getString(R.string.lilas_desc)))
        musicList.add(MusicModels(R.drawable.kanaboon_shillueto, getString(R.string.kana_music),getString(R.string.kana),getString(R.string.kana_album),getString(R.string.kana_desc)))
        musicList.add(MusicModels(R.drawable.takahashirie_chiisanakoinouta, getString(R.string.rie_music),getString(R.string.rie),getString(R.string.rie_album),getString(R.string.rie_desc)))
        musicList.add(MusicModels(R.drawable.flow_sign, getString(R.string.flow_music),getString(R.string.flow),getString(R.string.flow_album),getString(R.string.flow_desc)))
        musicList.add(MusicModels(R.drawable.eve_kaikaikitan, getString(R.string.eve_music),getString(R.string.eve),getString(R.string.eve_album),getString(R.string.eve_desc)))
        musicList.add(MusicModels(R.drawable.claris_alive, getString(R.string.claris_music),getString(R.string.claris),getString(R.string.claris_album),getString(R.string.claris_desc)))
        musicList.add(MusicModels(R.drawable.yoasobi_anoyumewonazotte, getString(R.string.yoasobi_music),getString(R.string.yoasobi),getString(R.string.yoasobi_album),getString(R.string.yoasobi_desc)))
        musicList.add(MusicModels(R.drawable.alia_hideandseek, getString(R.string.alia_music),getString(R.string.alia),getString(R.string.alia_album),getString(R.string.alia_desc)))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}