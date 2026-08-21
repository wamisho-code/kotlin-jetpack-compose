package com.example.myjetcompose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myjetcompose.model.BottomNavigation
import com.example.myjetcompose.ui.theme.font
val bottomNavItems=listOf<BottomNavigation>(
    BottomNavigation(
        title = "Home",
        route="home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        hasNews = false,
        badges = 0
    ),
    BottomNavigation(
        title = "Posts",
        route="posts",
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart,
        hasNews = false,
        badges = 0
    ),
    BottomNavigation(
        title = "Notification",
        route="notification",
        selectedIcon = Icons.Filled.Notifications,
        unselectedIcon = Icons.Outlined.Notifications,
        hasNews = true,
        badges = 5
    ),
    BottomNavigation(
        title = "Profile",
        route="profile",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        hasNews = false,
        badges = 0
    ),

)

@Composable
fun Screen1(name: String?,age: Int?){
    var selectedItem by remember {
        mutableStateOf(0)
    }
    Scaffold(
        bottomBar = {
            NavigationBar() {
                bottomNavItems.forEachIndexed { index, navigation ->
                    NavigationBarItem(
                        label = {
                            Text(navigation.title)
                        },
                        selected =index==selectedItem,
                        onClick = {
                            selectedItem=index
                        },
                        icon = {
                            BadgedBox(
                                badge= {if (navigation.badges !=0){
                                    Badge {
                                        Text(text = navigation.badges.toString())
                                    }
                                }else if(navigation.hasNews){
                                    Badge()
                                }
                                }
                            ){
                                Icon(
                                    imageVector = if(selectedItem==index)
                                        navigation.selectedIcon
                                    else
                                        navigation.unselectedIcon,
                                    contentDescription = navigation.title

                                )
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Magenta,
                            unselectedIconColor = Color.Blue,
                            selectedTextColor = Color.Yellow,
                            unselectedTextColor = Color.DarkGray,
                            indicatorColor = Color.Transparent

                        )

                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = Color.Yellow,

            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    tint = Color.Black,
                    contentDescription = null
                )
            }
        }
    ) {
        val padding=it
    }
}