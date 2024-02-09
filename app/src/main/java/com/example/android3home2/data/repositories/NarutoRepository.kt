package com.example.android3home2.data.repositories

import com.example.android3home2.R
import com.example.android3home2.data.AnimeModels

class NarutoRepository {
    private val recudo = mutableListOf<AnimeModels>(
        AnimeModels(R.drawable.naruto, "naruto"),
        AnimeModels(R.drawable.sasuke, "sasuke"),
    )

    fun addNaruto(anime: AnimeModels) {
        recudo.add(anime)
    }

    fun getNaruto() = recudo
}