package com.example.android3home2.data.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3home2.data.AnimeModels
import com.example.android3home2.data.repositories.NarutoRepository
import com.example.android3home2.utils.UiState

class NarutoViewModel : ViewModel() {
    private val _narutoLiveData = MutableLiveData<UiState<List<AnimeModels>>>()
    val narutoLiveData: LiveData<UiState<List<AnimeModels>>> = _narutoLiveData
    private val narutoRepository = NarutoRepository()

    init {
        getRecudo()
    }

    fun getRecudo() {

        _narutoLiveData.value = UiState(isLoading = false, success =  narutoRepository.getNaruto())
    }

    fun addNaruto(anime: AnimeModels) {
        narutoRepository.addNaruto(anime)
    }

    override fun onCleared() {
        super.onCleared()
    }
}