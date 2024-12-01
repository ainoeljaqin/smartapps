package com.example.smartapps.Model

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.smartapps.pages.Admin.BlueColor
import com.example.smartapps.pages.Admin.WhiteColor

data class User(
    val id: Int,
    val username: String,
    val email: String,
    val role: String,
)

data class TokenResponse(
    val access: String,
    val refresh: String
)

data class UserDetail(
    val name: String,
    val pekerjaan: String,
    val pendapatan: String,
    val pengeluaran: Map<String, String>,
    val aksesLayanan: Map<String, Boolean>
)

@Composable
fun UserRow(
    user: User,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = WhiteColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = user.username, style = MaterialTheme.typography.titleMedium, color = BlueColor)
                Text(text = user.email, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
            }
            TextButton(
                onClick = {
                    navController.navigate("detail_admin/${user.id}") // Pass user id to the detail screen
                },
                modifier = Modifier.padding(2.dp),
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Color(0xFFD7EDFF),
                    contentColor = BlueColor
                ),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = "Lihat",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}

