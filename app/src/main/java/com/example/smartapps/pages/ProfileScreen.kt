package com.example.smartapps.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import com.example.smartapps.ui.theme.SmartappsTheme

@Composable
fun ProfileScreen() {
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
            value = "",
            onValueChange = {},
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email Address Field
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Email Address") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Change Password Button
        Button(
            onClick = { /* TODO: Implement action */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Change Password")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Set Survey Preferences Button
        Button(
            onClick = { /* TODO: Implement action */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.outlinedButtonColors()
        ) {
            Text(text = "Set Survey Preferences")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Save Changes Button
        Button(
            onClick = { /* TODO: Implement action */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Save Changes")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Cancel Button
        OutlinedButton(
            onClick = { /* TODO: Implement action */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Cancel")
        }
    }
}
