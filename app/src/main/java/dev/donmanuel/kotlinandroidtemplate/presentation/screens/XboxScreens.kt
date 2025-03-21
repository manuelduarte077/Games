package dev.donmanuel.kotlinandroidtemplate.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.donmanuel.kotlinandroidtemplate.presentation.composables.CustomTopAppBar
import dev.donmanuel.kotlinandroidtemplate.presentation.composables.GameCard
import dev.donmanuel.kotlinandroidtemplate.presentation.composables.ShimmerEffect
import dev.donmanuel.kotlinandroidtemplate.presentation.viewmodels.GameViewModel
import dev.donmanuel.kotlinandroidtemplate.ui.utils.GamePlatform


@Composable
fun XboxScreens(
    viewModel: GameViewModel = hiltViewModel()
) {

    val games = viewModel.xboxGames.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value
    val favoriteGames = viewModel.favorites.collectAsState().value

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
            if (isLoading) {
                item(5) {
                    ShimmerEffect(
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .fillMaxWidth()
                            .height(60.dp)
                            .background(
                                Color.LightGray,
                                shape = RoundedCornerShape(12.dp)
                            )
                    )
                }
            } else {
                items(games) { game ->
                    GameCard(
                        game = game, platform = GamePlatform.XBOX,
                        onFavoriteClick = {
                            viewModel.toggleFavorite(game)
                        },
                        isFavorite = favoriteGames.any { it.id == game.id }
                    )
                }
            }
        }
    }

}