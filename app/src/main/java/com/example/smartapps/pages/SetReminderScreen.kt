package com.example.smartapps.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SetReminderScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Set Reminder")

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Text("Daily Reminder")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(checked = false, onCheckedChange = { /* Handle daily reminder */ })
        }
        Row {
            Text("Weekly Reminder")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(checked = true, onCheckedChange = { /* Handle weekly reminder */ })
        }
        Row {
            Text("Monthly Reminder")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(checked = false, onCheckedChange = { /* Handle monthly reminder */ })
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { /* Handle save action */ }) {
            Text("Save")
        }
    }
}
