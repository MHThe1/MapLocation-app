package com.example.maploca

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.rememberAsyncImagePainter

const val BASE_URL = "https://labs.anontech.info/cse489/t3/"

@Composable
fun MapLocaScreen(modifier: Modifier = Modifier) {
    val mapLocoViewModel: MainViewModel = viewModel()
    val viewstate = mapLocoViewModel.mapEntriesState.value
    Box(modifier = Modifier.fillMaxSize()) {
        when{
            viewstate.loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            viewstate.error != null -> {
                Text("Error Occurred")
            }
            else -> {
                MapEntriesScreen(entries = viewstate.list)
//                TestImage()
            }

        }
    }
}


@Composable
fun MapEntriesScreen(entries: List<MapEntries>) {
    LazyVerticalGrid(columns = GridCells.Fixed(1), modifier = Modifier.fillMaxSize()) {
        items(entries) {
                entry ->
            MapEntriesItem(entry = entry)
        }
    }
}

// Each MapEntries look
@Composable
fun MapEntriesItem(entry: MapEntries) {
    android.util.Log.d("MapEntriesItem", "Image URL: ${entry.image}")
    val fullImageUrl = "$BASE_URL${entry.image}"
    Column(modifier = Modifier.padding(8.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(
            painter = rememberAsyncImagePainter(fullImageUrl),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )

        Text(
            text = entry.title,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top=4.dp)

        )
    }
}