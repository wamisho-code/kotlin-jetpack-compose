package com.example.myjetcompose.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myjetcompose.ui.theme.font
import com.example.myjetcompose.viewmodel.HomeViewModel
import java.nio.file.WatchEvent

@Preview(showSystemUi = true)
@Composable
fun HomePage(viewModel: HomeViewModel= viewModel()) {
    val name by viewModel.userDate.collectAsState()
    val status by viewModel.status.collectAsState()
    var showError by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .windowInsetsPadding(WindowInsets.systemBars)
            .padding(30.dp)
            ,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.width(160.dp),
            text = "Change the name and age",
            fontFamily = font,
            fontSize = 26.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                modifier = Modifier.size(100.dp),
                imageVector = Icons.Rounded.Person,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text("Name $status: ${name.name} Age $status: ${name.age}")

        }

        OutlinedTextField(
            modifier = Modifier.background(Color.Transparent),
            value = name.name,
            onValueChange = { userName->
                viewModel.changeUserDate(userName,name.age)
            },
            label = {
                Text("Name")
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Blue,
                focusedLabelColor = Color.Red,
                unfocusedBorderColor = Color.DarkGray,
                unfocusedLabelColor = Color.DarkGray
            ),
            isError = showError,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Person,
                    contentDescription = null
                )
            }

        )
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            modifier = Modifier.background(Color.Transparent),
            value = if(name.age==0) "" else  name.age.toString(),
            onValueChange = {userAge->
                viewModel.changeUserDate(name.name,userAge.toIntOrNull()?:0)
            },
            label = {
                Text("Age")
            },
            isError = showError,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Blue,
                focusedLabelColor = Color.Red,
                unfocusedBorderColor = Color.DarkGray,
                unfocusedLabelColor = Color.DarkGray
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Rounded.DateRange,
                    contentDescription = null
                )
            }

        )
        Spacer(modifier = Modifier.height(30.dp))

        Button(

            onClick = {
                if (name.name.isEmpty() || name.age==0 || name.age.toString().isEmpty()){
                    showError=!showError
                }else{
                    viewModel.changeUserDate(name.name,name.age)
                    viewModel.changeStatus("Updated to")
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {
            Text("Update Data")
        }

    }
}