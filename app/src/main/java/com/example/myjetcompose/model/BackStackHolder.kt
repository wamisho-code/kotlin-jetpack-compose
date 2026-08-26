package com.example.myjetcompose.model

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myjetcompose.view.BackStackScreen1

@Composable
fun  BackStackHolder() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color= MaterialTheme.colorScheme.background
    ) {
        val bottomBarNavController= rememberNavController()
        //to now which screen we currently are and to get in of the screen (like route) we can use the navBackStackEntry
        val navBackStackEntry by bottomBarNavController.currentBackStackEntryAsState()
        val items= BottomNavigationItems.items
        Scaffold(
            bottomBar = {
                NavigationBar{
                    items.forEach { item->
                        val isSelected=  item.route==navBackStackEntry?.destination?.route
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = {
                                bottomBarNavController.navigate(item.route){
                                    popUpTo(bottomBarNavController.graph.findStartDestination().id){
                                        saveState=true
                                    }
                                    restoreState=true
                                    launchSingleTop=true
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector =
                                        if(isSelected)
                                            item.selectedIcon
                                        else
                                            item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            },
                            label = {
                                Text(text = item.title)
                            },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = Color.Transparent,
                            )
                        )
                    }
                }
            }
        ) {
            val padding= it
            BottomNavigationRouteControl(
                modifier = Modifier
                    .padding(bottom = padding.calculateBottomPadding())
                    .fillMaxSize()
                ,
                bottomNavController = bottomBarNavController
            )

        }

    }
}
@Composable
fun BottomNavigationRouteControl(modifier: Modifier,bottomNavController: NavHostController){
    NavHost(modifier=modifier,
        navController = bottomNavController, startDestination = "home" ) {
        composable("home"){
         //   BackStackScreen1(screenName = "Home")
        }
    }
}
