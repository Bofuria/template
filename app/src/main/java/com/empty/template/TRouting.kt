package com.empty.template

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home

sealed class TRouting(val path: String, val icon: Int, val label: String) {
    data object TScreen: TRouting("tscreen", R.drawable.ticon, "TScreen") // download image vector
}