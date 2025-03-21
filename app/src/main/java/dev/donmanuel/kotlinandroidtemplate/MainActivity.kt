package dev.donmanuel.kotlinandroidtemplate

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dagger.hilt.android.AndroidEntryPoint
import dev.donmanuel.kotlinandroidtemplate.presentation.navigation.BottomNavBar
import dev.donmanuel.kotlinandroidtemplate.presentation.navigation.NavItemList
import dev.donmanuel.kotlinandroidtemplate.presentation.screens.FavoriteScreens
import dev.donmanuel.kotlinandroidtemplate.presentation.screens.PlaystationScreens
import dev.donmanuel.kotlinandroidtemplate.presentation.screens.SwitchScreens
import dev.donmanuel.kotlinandroidtemplate.presentation.screens.XboxScreens
import dev.donmanuel.kotlinandroidtemplate.ui.theme.GamesTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GamesTheme {
                BottomNavScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavScreen() {
    var selectedItem by remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomNavBar(
                navItems = NavItemList.navItemList,
                selectedItem = selectedItem,
                onItemSelected = { index ->
                    selectedItem = index
                }
            )
        }
    ) {
        ContentScreen(selectedItem)
    }

}


@Composable
fun ContentScreen(selectedItemId: Int) {
    when (selectedItemId) {
        0 -> XboxScreens()
        1 -> SwitchScreens()
        2 -> PlaystationScreens()
        3 -> FavoriteScreens()
        else -> XboxScreens()
    }
}