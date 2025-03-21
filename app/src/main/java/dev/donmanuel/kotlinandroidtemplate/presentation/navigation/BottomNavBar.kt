package dev.donmanuel.kotlinandroidtemplate.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dev.donmanuel.kotlinandroidtemplate.ui.utils.NavItem

@Composable
fun BottomNavBar(
    navItems: List<NavItem>,
    selectedItem: Int,
    onItemSelected: (Int) -> Unit,
) {

    NavigationBar {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label
                    )
                },
                label = { Text(text = item.label) },
                selected = selectedItem == index,
                onClick = { onItemSelected(index) }
            )
        }
    }

}