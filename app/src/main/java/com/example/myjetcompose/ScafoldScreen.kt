package com.example.myjetcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Preview(showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScafoldScreen(){
    val scrollBehavior= TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )
    Scaffold(
        topBar = {
                TopBar(scrollBehavior=scrollBehavior)
        },

    )
    {
      paddingValues ->
        Screen2(
            modifier = Modifier.padding(paddingValues),paddingValues
        )

    }
}
@Composable
fun Screen2(modifier: Modifier= Modifier,paddingValues: PaddingValues){
    LazyColumn(
        modifier= modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        items(10){
            Box(
                modifier= Modifier.padding(horizontal = 16.dp)
                    .height(200.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(MaterialTheme.colorScheme.primary)

            )
            Spacer(modifier= Modifier.height(16.dp))
        }
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier= Modifier,scrollBehavior: TopAppBarScrollBehavior){
    TopAppBar(
        modifier=modifier
            .padding(top = 50.dp, start = 16.dp, end = 16.dp)
            .clip(RoundedCornerShape(100.dp))

        ,
        windowInsets = WindowInsets(top=0.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(0.6f)
        ),
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                "Search Your Note",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 17.sp

            )
        },

        navigationIcon = {
            Icon(
                imageVector = Icons.Rounded.Menu,
                contentDescription = null,
                modifier= Modifier
                    .padding(start = 16.dp, end = 8.dp)
                    .size(27.dp)
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Rounded.Notifications,
                contentDescription = null,
                modifier= Modifier
                    .padding(end = 8.dp)
                    .size(30.dp)
            )
            Icon(
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = null,
                modifier= Modifier
                    .padding(start = 16.dp, end = 8.dp)
                    .size(30.dp)
            )
        }

    )

}