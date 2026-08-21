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
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
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
import com.example.myjetcompose.ui.theme.font


@Composable
fun Screen1(name: String?,age: Int?){
    var showProgress by remember {
        mutableStateOf(false)
    }
    var textContent by remember{
        mutableStateOf(name+age)
    }
    Column(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(20.dp)
            ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text("Hello $textContent")
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = textContent,
            onValueChange = {
                textContent=it
            },
            label = {
                Text("Write Something")
            },
            textStyle = TextStyle(
                fontFamily = font,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Send,
                    contentDescription = null
                )
            }

        )
        if(showProgress){
            Spacer(modifier = Modifier.height(20.dp))
            CircularProgressIndicator(
                modifier = Modifier.size(30.dp),
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            onClick = {
                showProgress = !showProgress
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(14.dp),
            border = BorderStroke(
                width = 2.dp,
                color = Color.Green
            ),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Black,
                contentColor = Color.Yellow
            ),
            contentPadding = PaddingValues(horizontal = 24.dp)
        ) {
            Text(
                text = if (showProgress) "Stop Progress" else "Start Progress",
                fontFamily = font,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }

}