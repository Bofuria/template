package com.empty.empty_project.presentation.t

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController

@Composable
fun TScreen(
    navController: NavController,
    tViewModel: TViewModel
) {
    val items = tViewModel.items.collectAsState()
}