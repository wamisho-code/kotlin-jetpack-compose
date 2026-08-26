package com.example.myjetcompose.model

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavogationItemModel(

    val title:String,
    val route:String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)
