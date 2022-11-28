package com.example.utaumusic

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.utaumusic.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private var _binding: ActivitySplashScreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //animation
        val splashDuration = 2000

        binding.icon.alpha = 0f
        binding.icondesc.alpha = 0f
        binding.icon.translationZ = 800f
        binding.icon.translationY = 30f
        binding.icondesc.translationZ = -800f
        binding.icondesc.translationY = -30f
        binding.icon.animate().alpha(1f).translationY(0f).setStartDelay(500).setDuration(500).start()
        binding.icondesc.animate().alpha(1f).translationY(0f).setStartDelay(500).setDuration(500).start()


        //next
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            finish()
        }, splashDuration.toLong())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}