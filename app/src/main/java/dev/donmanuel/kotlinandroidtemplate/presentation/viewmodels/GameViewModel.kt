package dev.donmanuel.kotlinandroidtemplate.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.donmanuel.kotlinandroidtemplate.domain.model.Games
import dev.donmanuel.kotlinandroidtemplate.domain.usecases.GetGamesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getGamesUseCase: GetGamesUseCase,
) : ViewModel() {

    private val _xboxGames = MutableStateFlow<List<Games>>(emptyList())
    val xboxGames: StateFlow<List<Games>> = _xboxGames

    private val _playstationGames = MutableStateFlow<List<Games>>(emptyList())
    val playstationGames: StateFlow<List<Games>> = _playstationGames

    private val _switchGames = MutableStateFlow<List<Games>>(emptyList())
    val switchGames: StateFlow<List<Games>> = _switchGames

    private val _isLoading = MutableStateFlow<Boolean>(true)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    init {
        fetchXboxGames()
        fetchPlaystationGames()
        fetchSwitchGames()
    }

    private fun fetchXboxGames() {
        viewModelScope.launch {
            try {
                val games = getGamesUseCase.getXboxGames()
                _xboxGames.value = games
                _isLoading.value = false
            } catch (_: Exception) {
                _isLoading.value = false
            }
        }
    }

    fun fetchPlaystationGames() {
        viewModelScope.launch {
            try {
                val games = getGamesUseCase.getPlaystationGames()
                _playstationGames.value = games
                _isLoading.value = false
            } catch (_: Exception) {
                _isLoading.value = false
            }
        }
    }

    fun fetchSwitchGames() {
        viewModelScope.launch {
            try {
                val games = getGamesUseCase.getSwitchGames()
                _switchGames.value = games
                _isLoading.value = false
            } catch (_: Exception) {
                _isLoading.value = false
            }
        }
    }

}