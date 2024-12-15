package com.example.smartapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.smartapps.Views.UserViewModel
import com.example.smartapps.networks.MainApp
import com.example.smartapps.pages.ServiceAccessSurveyScreen
import com.example.smartapps.ui.theme.SmartappsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val userViewModel: UserViewModel = viewModel()
            SmartappsTheme {
                MainApp(viewModel = userViewModel)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    SmartappsTheme {
        val navController = rememberNavController()
        // Uncomment if you want to preview different screens
//        HomeScreen(navController)
//        IncomeSurveyScreen(navController)
//        ExpenseSurveyScreen(navController)
//        ServiceAccessSurveyScreen(navController)
    }
}
