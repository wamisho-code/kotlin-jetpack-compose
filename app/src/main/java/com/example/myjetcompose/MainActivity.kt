package com.example.myjetcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import com.example.myjetcompose.ui.theme.MyJetComposeTheme
import com.example.myjetcompose.ui.theme.font
import coil3.size.Size
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    companion object{
        val items=mutableListOf<Item>(
            Item("item1",R.drawable.camel),
            Item("item2",R.drawable.goat),
            Item("item3",R.drawable.camel),
            Item("item4",R.drawable.goat),
            Item("item5",R.drawable.camel),
            Item("item6",R.drawable.owl),
            Item("item7",R.drawable.camel),
            Item("item8",R.drawable.goat),
            Item("item9",R.drawable.camel),
            Item("item10",R.drawable.owl),
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyJetComposeTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    val navHostController =rememberNavController()
                    NavHost(navHostController,startDestination="home_screen"){
                        composable("home_screen"){
                            HomeScreen(navHostController)
                        }
                        composable("lazy_row_screen"){
                            LazyRowScreen(navHostController)
                        }
                        composable("lazy_column_screen"){
                            LazyColumnScreen()
                        }
                        composable("lazy_grid_screen"){
                            LazyGridScreen()
                        }
                        composable("screen1/{name}/{age}") {
                            val passedName=it.arguments?.getString("name")
                            val passedAge= it.arguments?.getString("age")?.toIntOrNull()
                            Screen1(passedName,passedAge)
                        }

                    }
                }
            }
        }
    }

}
@Composable
fun WelcomeText(){
    Column(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState()),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
    }
}
@Composable
fun HomeScreen(navHostController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
            navHostController.navigate("lazy_row_screen")
        }) {
            Text("Lazy Row")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                navHostController.navigate("lazy_column_screen")
            }) {
            Text("Lazy Column")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                navHostController.navigate("lazy_grid_screen")
            }) {
            Text("Lazy Grid")
        }
        Spacer(modifier = Modifier.height(30.dp))

    }
}
