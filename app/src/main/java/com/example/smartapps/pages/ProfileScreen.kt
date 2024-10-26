package com.example.smartapps.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartapps.R
import androidx.navigation.NavController
import com.example.smartapps.components.BackButton
import com.example.smartapps.components.SubmitButton


@Composable
fun ProfileScreen(navController: NavController) {
    var textPhoneNumber by remember { mutableStateOf("") }
    var textEmail by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Profile Picture
        Image(
            painter = painterResource(id = R.drawable.mr_bean), // Ganti dengan gambar yang sesuai
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Profile Name
        Text(
            text = "Mr. Bean",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        // Profile Description
        Text(
            text = "Description",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Location
        Text(
            text = "Location",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = "Somewhere in the Country",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Phone Number Field
        OutlinedTextField(
            value = textPhoneNumber,
            onValueChange = { textPhoneNumber = it },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email Address Field
        OutlinedTextField(
            value = textEmail,
            onValueChange = { textEmail = it },
            label = { Text("Email Address") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Change Password Button
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { /* TODO: Implement action */ },
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                colors = ButtonDefaults.outlinedButtonColors()
            ) {
                Text(
                    text = "Change Password",
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

//        // Set Survey Preferences Button
//        Button(
//            onClick = { /* TODO: Implement action */ },
//            modifier = Modifier.fillMaxWidth(),
//            colors = ButtonDefaults.outlinedButtonColors()
//        ) {
//            Text(text = "Set Survey Preferences")
//        }

        Spacer(modifier = Modifier.height(16.dp))

        // Save Changes Button
        SubmitButton(
            text = "Save Changes",
            onClick = { navController.navigate("home") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Cancel Button
        BackButton(
            text = "Cancel",
            onClickBack = { navController.navigate("home") }
        )
    }
}
