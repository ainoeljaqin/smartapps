package com.example.smartapps.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartapps.components.BackButton
import com.example.smartapps.components.BottomNavigationBar
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.CameraPosition

@Composable
fun MapScreen(navController: NavController) {
    val ngadiluwihLocation = LatLng(-7.791679, 112.007790)  // Koordinat untuk Ngadiluwih
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(ngadiluwihLocation, 15f)
    }
    val markerState = rememberMarkerState(position = ngadiluwihLocation)

    Scaffold(
        bottomBar = {
            BackButton(
                text = "Back",
                onClickBack = { navController.navigate("home") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Menampilkan peta dengan marker di Ngadiluwih
            GoogleMap(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                cameraPositionState = cameraPositionState
            ) {
                Marker(
                    state = markerState,
                    title = "Ngadiluwih",
                    snippet = "Kabupaten Kediri"
                )
            }
        }
    }
}
