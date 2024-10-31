package com.example.smartapps.pages.Admin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartapps.Model.User
import com.example.smartapps.Model.UserRow

val BlueColor = Color(0xFF2196F3)
val WhiteColor = Color.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminDashboard(
    users: List<User>,
    navController: NavController
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Dashboard Admin", color = WhiteColor) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = BlueColor
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(users) { user ->
                    UserRow(user, navController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAdminDashboard() {
    val navController = rememberNavController()
    val users = listOf(
        User("Alice", "alice@example.com", "Active"),
        User("Bob", "bob@example.com", "Inactive"),
        User("Charlie", "charlie@example.com", "Active"),
        User("Dave", "dave@example.com", "Inactive"),
    )
    AdminDashboard(users, navController)
}
