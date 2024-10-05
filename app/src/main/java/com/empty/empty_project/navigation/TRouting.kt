package com.empty.empty_project.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.graphics.vector.ImageVector
import com.empty.empty_project.R

sealed class TRouting(val path: String, val icon: ImageVector, val label: String) {
    data object TScreen: TRouting("tscreen", Icons.Default.Add, "TScreen") // download image vector
}