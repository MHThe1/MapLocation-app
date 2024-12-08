package com.example.maploca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.maploca.ui.theme.MapLocaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Ensure edge-to-edge is enabled
        setContent {
            MapLocaTheme {
                // Wrapping Scaffold with a Surface for better theming consistency
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White // Or use MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        contentColor = Color.Black // Optional: Ensures proper text color
                    ) { innerPadding ->
                        MapLocaScreen(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}