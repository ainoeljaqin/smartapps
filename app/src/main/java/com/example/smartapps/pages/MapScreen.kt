package com.example.smartapps.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MapScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Placeholder untuk peta, bisa diganti dengan komponen Google Maps atau MapView lainnya
        Text("Map of Ngadiluwih", fontSize = 22.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { /* Handle back to home action */ }) {
            Text("Back to Home")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { /* Handle detailed reports action */ }) {
            Text("Detailed Reports")
        }
    }
}
