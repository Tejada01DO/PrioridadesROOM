package com.ucne.prioridades_room.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItems(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val listOfNavItems = listOf(
    NavItems(
        label = "Home",
        icon = Icons.Default.Home,
        route = Screens.Home.name
    ),
    NavItems(
        label = "Prioridad",
        icon = Icons.Default.Add,
        route = Screens.PrioridadScreen.name
    ),
    NavItems(
        label = "Consulta",
        icon = Icons.Default.List,
        route = Screens.C_Prioridades.name
    )
)
