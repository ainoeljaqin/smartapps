package com.example.smartapps.networks

import WelcomeScreen
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartapps.Models.UserDetail
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
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.smartapps.Views.UserViewModel


@Composable
fun MainApp(viewModel: UserViewModel) {
    val navController = rememberNavController()
    val context = LocalContext.current


//    val users = listOf(
//        User(1, "Alice", "alice@example.com", "user"),
//        User(2, "Bob", "bob@example.com", "user"),
//        User(3, "Charlie", "charlie@example.com", "user"),
//        User(4, "Dave", "dave@example.com", "user")
//    )

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


    SmartappsTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "welcome",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("welcome") { WelcomeScreen(navController) }
                composable("register") {
                    RegisterScreen(navController, viewModel) { message ->
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                        navController.navigate("login")
                    }
                }
                composable("login") {
                    LoginScreen(navController, viewModel) { token ->
                        viewModel.fetchUser(onSuccess = { user ->
                            if (user.is_staff) {
                                navController.navigate("dashboard_admin")
                            } else {
                                navController.navigate("home")
                            }
                        }, onError = { error ->
                            // Handle error
                            println("Error fetching user: $error")
                        })
                    }
                }
                composable("home") { HomeScreen(navController) }
                composable("profile") { ProfileScreen(navController) }
                composable("set_reminder") { SetReminderScreen() }
                composable("map") { MapScreen(navController) }
                composable("job_survey") { JobSurveyScreen(navController, viewModel) }
                composable("income_survey") { IncomeSurveyScreen(navController, viewModel) }
                composable("expense_survey") { ExpenseSurveyScreen(navController, viewModel) }
                composable("service_access_survey") {
                    ServiceAccessSurveyScreen(
                        navController = navController,
                        viewModel = viewModel,
                        onSuccess = { message -> /* Tindakan jika sukses */ },
                        onError = { error -> /* Tindakan jika error */ }
                    )
                }
                composable("dashboard_admin") { AdminDashboard(viewModel, navController) }
                composable("detail_admin/{userId}") { backStackEntry ->
                    val userId = backStackEntry.arguments?.getString("userId")?.toInt() ?: return@composable
                    // Fetch the user details using the userId
                    UserDetailPage(userId = userId, navController = navController, viewModel)
                }
            }
        }
    }
}
