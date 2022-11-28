package com.example.utaumusic.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MusicModels(
    val avatar: Int?,
    val title: String?,
    val artist: String?,
    val album: String?,
    val desc: String?
) : Parcelable
