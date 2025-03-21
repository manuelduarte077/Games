package dev.donmanuel.kotlinandroidtemplate.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import dev.donmanuel.kotlinandroidtemplate.ui.utils.NavItem


object NavItemList {

    val navItemList = listOf(
        NavItem(
            label = "Xbox",
            icon = Icons.Filled.Close
        ),
        NavItem(
            label = "Switch",
            icon = Icons.Filled.Info
        ),
        NavItem(
            label = "Playstation",
            icon = Icons.Filled.PlayArrow
        ),
        NavItem(
            label = "Favorites",
            icon = Icons.Filled.Favorite,
        )
    )

}