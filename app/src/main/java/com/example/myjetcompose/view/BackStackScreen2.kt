package com.example.myjetcompose.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun BackStackScreen2(screenNavController: NavController,screenName: String,screenNumber: Int){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text("$screenName $screenNumber",fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                screenNavController.navigate("")
            }
        ) {
            Text("Go to $screenName $screenNumber",fontSize = 20.sp)
        }

    }
}