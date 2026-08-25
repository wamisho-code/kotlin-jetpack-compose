package com.example.myjetcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myjetcompose.viewmodel.MyViewModel

@Composable
fun EffectHandler(myViewModel: MyViewModel= viewModel()){

    val nameState by myViewModel.nameState.collectAsState()

    LaunchedEffect(nameState) {

        myViewModel.loadName()
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        Text(nameState)
        Button(
            onClick = {
                myViewModel.addToName()
            }
        ) {
            Text("Change Name")
        }

    }

}