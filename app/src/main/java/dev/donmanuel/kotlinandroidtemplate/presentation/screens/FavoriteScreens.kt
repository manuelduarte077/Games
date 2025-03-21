package dev.donmanuel.kotlinandroidtemplate.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.donmanuel.kotlinandroidtemplate.data.local.FavoriteGame
import dev.donmanuel.kotlinandroidtemplate.presentation.composables.CustomTopAppBar
import dev.donmanuel.kotlinandroidtemplate.presentation.viewmodels.GameViewModel

@Composable
fun FavoriteScreens(
    viewModel: GameViewModel = hiltViewModel()
) {

    val favoriteGames = viewModel.favorites.collectAsState().value


    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "Favorite Games",
                showSearch = false,
                showNavigationIcon = false
            )
        },
    ) { paddingValues ->
        FavoriteGamesContent(
            favoriteGames = favoriteGames,
            paddingValues = paddingValues,
        )
    }
}

@Composable
fun FavoriteGamesContent(
    favoriteGames: List<FavoriteGame>,
    paddingValues: PaddingValues,
    viewModel: GameViewModel = hiltViewModel()
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(favoriteGames) { game ->
            GameCard(game = game, onRemoveClick = {
                viewModel.removeGameFromFavorites(game)
            })
        }
    }
}

@Composable
fun GameCard(game: FavoriteGame, onRemoveClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = game.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Black
            )

            Text(
                text = "Developers: ${game.developers.joinToString(", ")}",
                modifier = Modifier.padding(horizontal = 8.dp),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onRemoveClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Text("Remove")
            }
        }
    }
}