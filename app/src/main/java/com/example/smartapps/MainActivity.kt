package com.example.smartapps

import WelcomeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartapps.Model.User
import com.example.smartapps.Model.UserDetail
import com.example.smartapps.pages.Admin.AdminDashboard
import com.example.smartapps.pages.Admin.UserDetailPage

import com.example.smartapps.pages.ExpenseSurveyScreen
import com.example.smartapps.pages.HomeScreen
import com.example.smartapps.pages.MapScreen
import com.example.smartapps.pages.ProfileScreen
import com.example.smartapps.pages.SetReminderScreen
import com.example.smartapps.pages.IncomeSurveyScreen
import com.example.smartapps.pages.JobSurveyScreen
import com.example.smartapps.pages.Login.LoginScreen
import com.example.smartapps.pages.Register.RegisterScreen
import com.example.smartapps.pages.ServiceAccessSurveyScreen
import com.example.smartapps.ui.theme.SmartappsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartappsTheme {
                val navController = rememberNavController()
                val users = listOf(
                    User("Alice", "alice@example.com", "Active"),
                    User("Bob", "bob@example.com", "Inactive"),
                    User("Charlie", "charlie@example.com", "Active"),
                    User("Dave", "dave@example.com", "Inactive"),
                )
                val pengeluaran = mapOf(
                    "Makanan" to "Rp 1,000,000",
                    "Pendidikan" to "Rp 500,000",
                    "Kesehatan" to "Rp 200,000",
                    "Pajak Transportasi" to "Rp 150,000",
                    "Pajak PBB" to "Rp 300,000",
                    "Listrik per bulan" to "Rp 250,000"
                )
                val aksesLayanan = mapOf(
                    "Akses layanan kesehatan" to true,
                    "Akses layanan Keuangan" to false,
                    "Bantuan Pemerintah" to true
                )
                val userDetail = UserDetail(
                    name = "Alice",
                    pekerjaan = "Guru",
                    pendapatan = "Rp 5,000,000",
                    pengeluaran = pengeluaran,
                    aksesLayanan = aksesLayanan
                )
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "welcome",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("welcome") { WelcomeScreen(navController) }
                        composable("register") { RegisterScreen(navController) }
                        composable("login") { LoginScreen(navController) }
                        composable("home") { HomeScreen(navController) }
                        composable("profile") { ProfileScreen(navController) }
                        composable("set_reminder") { SetReminderScreen() }
                        composable("map") { MapScreen(navController) }
                        composable("job_survey") { JobSurveyScreen(navController) }
                        composable("income_survey") { IncomeSurveyScreen(navController) }
                        composable("expense_survey") { ExpenseSurveyScreen(navController) }
                        composable("service_access_survey") { ServiceAccessSurveyScreen(navController) }
                        composable("dasboard_admin") { AdminDashboard(users, navController) }
                        composable("detail_admin") { UserDetailPage(
                            userDetail = userDetail,
                            navController
                        ) }
                    }
                }
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
        WelcomeScreen(navController)
    }
}
