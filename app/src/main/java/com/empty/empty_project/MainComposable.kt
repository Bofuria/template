package com.empty.empty_project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.empty.empty_project.navigation.TRouting
import com.empty.empty_project.presentation.t.TScreen
import com.empty.empty_project.presentation.t.TViewModel

@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        BottomNavigationItem(
            modifier = Modifier
                .background(
                    if(currentRoute == TRouting.TScreen.path)
                        MaterialTheme.colorScheme.onSecondaryContainer
                    else
                        MaterialTheme.colorScheme.secondaryContainer
                ),
            selected = currentRoute == TRouting.TScreen.path,
            onClick = {
                navController.navigate(TRouting.TScreen.path) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            },
            icon = { Icon(
                modifier = Modifier
                    .padding(8.dp),
                imageVector = TRouting.TScreen.icon,
                contentDescription = null,
                tint = if(currentRoute == TRouting.TScreen.path)
                    MaterialTheme.colorScheme.inverseOnSurface
                else
                    MaterialTheme.colorScheme.inverseSurface
            )
           },
            label = { Text(
                text = TRouting.TScreen.label,
                color = if(currentRoute == TRouting.TScreen.path)
                    MaterialTheme.colorScheme.inverseOnSurface
                else
                    MaterialTheme.colorScheme.inverseSurface
                )
            }
        )
    }
}

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = TRouting.TScreen.path) {
        composable(TRouting.TScreen.path) { backStack ->
            val parent = remember(backStack) {
                navController.getBackStackEntry(navController.graph.id)
            }
            val habitsScreenViewModel = hiltViewModel<TViewModel>(parent)
            TScreen(
                navController,
                habitsScreenViewModel
            )
        }
    }
}