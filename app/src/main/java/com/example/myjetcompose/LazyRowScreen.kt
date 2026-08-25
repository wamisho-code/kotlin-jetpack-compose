//package com.example.myjetcompose
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.CheckCircle
//import androidx.compose.material.icons.materialIcon
//import androidx.compose.material3.Button
//import androidx.compose.material3.FilledIconButton
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButtonColors
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.OutlinedButton
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.myjetcompose.ui.theme.font
//
////@Preview(showBackground = true)
//@Composable
//fun LazyRowScreen(navHostController: NavHostController){
//
//    LazyRow(
//        modifier = Modifier.fillMaxSize(),
//        horizontalArrangement = Arrangement.spacedBy(80.dp),
//        contentPadding = PaddingValues(16.dp)
//    ) {
//        itemsIndexed(MainActivity.items){ index,item->
//            Spacer(modifier = Modifier.height(8.dp))
//            RowItem(item,navHostController)
//            Spacer(modifier = Modifier.height(8.dp))
//
//        }
//
//    }
//    Spacer(modifier = Modifier.height(20.dp))
//
//
//}
//@Composable
//fun RowItem(item: Item,navHostController: NavHostController){
//    var name="Wamisho Siraj"
//    var age=23
//    Column(
//        modifier = Modifier.height(350.dp).width(200.dp)
//            .padding(horizontal = 8.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Image(
//            modifier = Modifier.fillMaxWidth()
//                .height(300.dp)
//                .clip(RoundedCornerShape(30.dp))
//
//            ,
//
//            painter = painterResource(item.image),
//            contentDescription = item.title,
//            contentScale = ContentScale.Crop
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(
//            text = item.title,
//            fontFamily = font,
//            fontWeight = FontWeight.SemiBold
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//
//        FilledIconButton(
//
//            onClick = {
//                navHostController.navigate("screen1")
//            }
//        ) {
//            Icon(
//                imageVector = Icons.Default.CheckCircle,
//                tint = Color.Yellow,
//                contentDescription=null
//            )
//        }
//    }
//}