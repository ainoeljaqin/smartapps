package com.example.smartapps.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartapps.R
import com.example.smartapps.ui.theme.PrimaryButtonColor

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo SMART",
            modifier = Modifier
                .width(200.dp),
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Economic Survey",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Understand community needs.")
        Text(text = "Contribute to local development.")
        Text(text = "Confidential participation.")
        Spacer(modifier = Modifier.height(32.dp))

        // Survey Form Button
        Button(
            onClick = { navController.navigate("job_survey") },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryButtonColor)
        ){
            Text(text = "Mulai Survey!")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Profile Button
        Button(
            onClick = { navController.navigate("profile") },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryButtonColor)
        ){
            Text(text = "Profile")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Economic Map Button
        Button(
            onClick = { navController.navigate("map") },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryButtonColor)
        ){
            Text(text = "Map")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Reminder Settings Button
        Button(
            onClick = { navController.navigate("set_reminder") },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryButtonColor)
        ){
            Text(text = "Settings")
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
