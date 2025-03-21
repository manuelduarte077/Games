package dev.donmanuel.kotlinandroidtemplate.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.donmanuel.kotlinandroidtemplate.presentation.composables.CustomTopAppBar
import dev.donmanuel.kotlinandroidtemplate.presentation.composables.GameCard
import dev.donmanuel.kotlinandroidtemplate.presentation.viewmodels.GameViewModel


@Composable
fun XboxScreens(
    viewModel: GameViewModel = hiltViewModel()
) {

    val games = viewModel.xboxGames.collectAsState().value

    var showSearch by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "Xbox Games",
                showSearch = showSearch,
                onSearchTextChanged = { text ->
                    searchText = text
                },
                showNavigationIcon = false
            )
        },

        ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            items(games) { game ->
                GameCard(game = game)
            }
        }
    }

}