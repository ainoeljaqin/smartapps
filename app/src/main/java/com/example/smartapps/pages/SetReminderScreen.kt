package com.example.smartapps.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartapps.components.BackButton
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun SetReminderScreen(navController: NavController) {
    var isDailyReminder by remember { mutableStateOf(false) }
    var isWeeklyReminder by remember { mutableStateOf(true) }
    var isMonthlyReminder by remember { mutableStateOf(false) }
    var customMessage by remember { mutableStateOf("") }

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
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Set Reminder",
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Daily Reminder")
                Spacer(modifier = Modifier.width(8.dp))
                Switch(
                    checked = isDailyReminder,
                    onCheckedChange = { isDailyReminder = it }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Weekly Reminder")
                Spacer(modifier = Modifier.width(8.dp))
                Switch(
                    checked = isWeeklyReminder,
                    onCheckedChange = { isWeeklyReminder = it }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Monthly Reminder")
                Spacer(modifier = Modifier.width(8.dp))
                Switch(
                    checked = isMonthlyReminder,
                    onCheckedChange = { isMonthlyReminder = it }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text("Custom Message")
            BasicTextField(
                value = customMessage,
                onValueChange = { customMessage = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(56.dp)
                    .background(color = Color.LightGray, shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = { navController.navigate("home") }) {
                Text("Save")
            }
        }
    }
}
