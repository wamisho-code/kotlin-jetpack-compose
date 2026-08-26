package com.example.myjetcompose.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myjetcompose.view.BackStackScreen1


@Composable
fun ScreensNavigation(selectedBottomBarItem:String){
    val screenNavController= rememberNavController()
    NavHost(screenNavController, startDestination ="$selectedBottomBarItem 1" ){
        composable("$selectedBottomBarItem 1"){
            BackStackScreen1(screenNavController,screenName = selectedBottomBarItem, screenNumber = 1)
            BackStackScreen1(screenNavController,screenName = selectedBottomBarItem, screenNumber = 2)
            BackStackScreen1(screenNavController,screenName = selectedBottomBarItem, screenNumber = 3)
        }
    }
}
class BottomNavigationItems {
    companion object{
        val items = listOf<BottomNavogationItemModel>(
            BottomNavogationItemModel(
                title = "Home",
                route = "home",
                selectedIcon = Icons.Filled.Home,
                unselectedIcon = Icons.Outlined.Home
            ),
            BottomNavogationItemModel(
                title = "settings",
                route="settings",
                selectedIcon = Icons.Filled.Settings,
                unselectedIcon = Icons.Outlined.Settings
            ),
            BottomNavogationItemModel(
                title = "profile",
                route="profile",
                selectedIcon = Icons.Filled.Person,
                unselectedIcon = Icons.Outlined.Person
            )

        )
    }
}