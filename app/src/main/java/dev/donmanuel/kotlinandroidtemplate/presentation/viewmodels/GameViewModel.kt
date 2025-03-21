package dev.donmanuel.kotlinandroidtemplate.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.donmanuel.kotlinandroidtemplate.domain.model.Games
import dev.donmanuel.kotlinandroidtemplate.domain.repository.GameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val gameRepository: GameRepository
) : ViewModel() {

    private val _xboxGames = MutableStateFlow<List<Games>>(emptyList())
    val xboxGames: StateFlow<List<Games>> = _xboxGames

    init {
        fetchXboxGames()
    }

    private fun fetchXboxGames() {
        viewModelScope.launch {
            _xboxGames.value = gameRepository.getXboxGames()
        }
    }

}