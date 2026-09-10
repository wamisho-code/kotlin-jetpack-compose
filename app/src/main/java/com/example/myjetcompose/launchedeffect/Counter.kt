package com.example.myjetcompose.launchedeffect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun Counter(max:Int,onCount:(Int)->Unit){
    var counter by remember {
        mutableStateOf(0)
    }
    LaunchedEffect(key1 = counter) {
        if(counter>=max+1){
            return@LaunchedEffect
        }
        delay(1.seconds)
        onCount(counter)
        counter++
    }

}