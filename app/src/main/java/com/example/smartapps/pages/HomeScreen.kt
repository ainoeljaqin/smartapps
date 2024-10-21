package com.example.smartapps.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "SMART",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Economic Survey",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Understand community needs.")
        Text(text = "Contribute to local development.")
        Text(text = "Confidential participation.")
        Spacer(modifier = Modifier.height(32.dp))

        // Survey Form Button
        Button(onClick = {
            navController.navigate("survey_form")
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Survey Form")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Reminder Settings Button
        Button(onClick = {
            navController.navigate("set_reminder")
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Reminder Settings")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Economic Map Button
        Button(onClick = {
            navController.navigate("map")
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Economic Map")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Profile Button
        Button(onClick = {
            navController.navigate("profile")
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Profile")
        }
    }
}
