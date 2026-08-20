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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyJetComposeTheme {
                WelcomeText()
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

            Image(
                modifier = Modifier

                    .clip(RoundedCornerShape(20.dp)),
                painter = painterResource(R.drawable.camel),
                contentDescription = "Image of camel"
            )
            Spacer(modifier = Modifier.height(60.dp))
            val imageurl="https://static0.thesportsterimages.com/wordpress/wp-content/uploads/wm/2024/08/why-roman-reigns-works-a-part-time-wwe-schedule-explained.jpg?w=1200&h=675&fit=crop"
            val model=ImageRequest
                .Builder(LocalContext.current)
                .data(imageurl)
                .size(Size.ORIGINAL)
                .build()

            Spacer(modifier = Modifier.height(60.dp))
        val painter = rememberAsyncImagePainter(model = model)
        val imageState = painter.state.collectAsState().value   // ← .value unwraps the State<T> wrapper

        if (imageState is AsyncImagePainter.State.Success) {
            Image(
                modifier = Modifier.clip(RoundedCornerShape(20.dp)),
                painter = painter,
                contentDescription = null
            )
        }
        if (imageState is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(40.dp),
                color = MaterialTheme.colorScheme.primary
            )
        }
        if (imageState is AsyncImagePainter.State.Error) {
            Icon(imageVector = Icons.Rounded.Warning, contentDescription = null)
        }





    }
}
