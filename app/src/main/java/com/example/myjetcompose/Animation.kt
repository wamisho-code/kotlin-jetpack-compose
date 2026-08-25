package com.example.myjetcompose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimationFun(){
    var isVisible by remember {
        mutableStateOf(true)
    }
    val sizeAnime  by animateDpAsState(
        targetValue = if (isVisible) 300.dp
        else 20.dp,
        label = "size",
        animationSpec = tween(
            delayMillis = 500,
            durationMillis = 5000,
            easing = FastOutSlowInEasing
        )
    )
    val tranistion= rememberInfiniteTransition()
    val colorAnime2 by  tranistion.animateColor(
        initialValue = Color.Magenta,
        targetValue = Color.DarkGray,
        animationSpec = infiniteRepeatable(
            tween(
                3000
            )
        ),
        label = "color2"
    )

    val colorAnime by  animateColorAsState(
        targetValue = if(isVisible) Color.Blue
        else Color.Red,
        label = "color",
        animationSpec = tween(
            delayMillis = 1000,
            durationMillis = 5000,
            easing = FastOutSlowInEasing
        )
    )
    val circleAnime by animateDpAsState(
        targetValue = if (isVisible) 150.dp else 20.dp,
        label = "circle",
        animationSpec = tween(
            delayMillis = 500,
            durationMillis = 5000
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(80.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Button(
            onClick = {
                isVisible=!isVisible

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green
            )
            ) {
            Text("Click")
        }
        Spacer(modifier = Modifier.height(59.dp))
        Column(
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(circleAnime))
                .background(colorAnime)
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            AnimatedVisibility(
//                visible = isVisible,
//                enter = slideInHorizontally()+ fadeIn(),
//                exit = slideOutHorizontally ()+ fadeOut()
//            ) {
//                Box(
//                    modifier = Modifier
//                        .size(200.dp)
//                        .background(Color.Black)
//                )
//
//            }

        }
    }
}