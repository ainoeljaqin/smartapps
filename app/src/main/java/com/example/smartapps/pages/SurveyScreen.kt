package com.example.smartapps.pages

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartapps.Models.Survey
import com.example.smartapps.components.DropdownInputField
import com.example.smartapps.components.BottomNavigationBar
import com.example.smartapps.components.CheckboxWithLabel
import androidx.compose.ui.platform.LocalContext
import com.example.smartapps.Views.UserViewModel
import java.lang.Error

@Composable
fun JobSurveyScreen(
    navController: NavController,
    viewModel: UserViewModel,
) {
    var selectedJob by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                onClick = { navController.navigate("income_survey") },
                onClickBack = { navController.navigate("home") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Survey",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Detail Pekerjaan",
                fontSize = 20.sp,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Input for Income
            OutlinedTextField(
                value = selectedJob,
                onValueChange = {
                    selectedJob = it
                    viewModel.job = it
                },
                label = { Text("Tulis Pekerjaan anda disini") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun IncomeSurveyScreen(
    navController: NavController,
    viewModel: UserViewModel,
) {
    var selectedIncome by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                onClick = { navController.navigate("expense_survey") },
                onClickBack = { navController.navigate("job_survey") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Survey",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Detail Pendapatan",
                fontSize = 20.sp,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Input for Income
            OutlinedTextField(
                value = selectedIncome,
                onValueChange = {
                    selectedIncome = it
                    viewModel.income = it
                },
                label = { Text("Pendapatan per bulan") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

        }
    }
}

@Composable
fun ExpenseSurveyScreen(
    navController: NavController,
    viewModel: UserViewModel,
) {
    // State for all dropdown
    var selectedFood by remember { mutableStateOf("") }
    var selectedEducation by remember { mutableStateOf("") }
    var selectedHealth by remember { mutableStateOf("") }
    var selectedTransportationTax by remember { mutableStateOf("") }
    var selectedPBBTax by remember { mutableStateOf("") }
    var selectedElecttricity by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                onClick = { navController.navigate("service_access_survey") },
                onClickBack = { navController.navigate("income_survey") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Survey",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Detail Pengeluaran",
                fontSize = 20.sp,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Input for Food
            OutlinedTextField(
                value = selectedFood,
                onValueChange = {
                    selectedFood = it
                    viewModel.foodExpense = it
                },
                label = { Text("kira2 pengeluaran makanan per bulan") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Input for Education
            OutlinedTextField(
                value = selectedEducation,
                onValueChange = {
                    selectedEducation = it
                    viewModel.educationExpense = it
                },
                label = { Text("kira2 pengeluaran pendidikan per bulan") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Input for Health
            OutlinedTextField(
                value = selectedHealth,
                onValueChange = {
                    selectedHealth = it
                    viewModel.healthExpense = it
                },
                label = { Text("kira2 pengeluaran biaya kesehatan per bulan") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Input for Transportation Tax
            OutlinedTextField(
                value = selectedTransportationTax,
                onValueChange = {
                    selectedTransportationTax = it
                    viewModel.transportationTaxExpense = it
                },
                label = { Text("biaya pengeluaran kendaraan & pajak") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Input for PBB Tax
            OutlinedTextField(
                value = selectedPBBTax,
                onValueChange = {
                    selectedPBBTax = it
                    viewModel.pbbTaxExpense = it
                },
                label = { Text("biaya pajak bangunan") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Input for Electricity
            OutlinedTextField(
                value = selectedElecttricity,
                onValueChange = {
                    selectedElecttricity = it
                    viewModel.electricityExpense = it
                },
                label = { Text("biaya listrik per bulan") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ServiceAccessSurveyScreen(
    navController: NavController,
    viewModel: UserViewModel,
    onSuccess: (Survey) -> Unit,
    onError: (String) -> Unit
) {
    var aksesKeuangan by remember { mutableStateOf(false) }
    var aksesKesehatan by remember { mutableStateOf(false) }
    var bantuanPemerintah by remember { mutableStateOf(false) }

    val context = LocalContext.current

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                onClick = {
                    val surveyData = viewModel.getSurveyData()
                    viewModel.postUserSurvey(surveyData,
                        onSuccess = {
                            // Tampilkan Toast sukses dan navigasi ke home
                            Toast.makeText(context, "Survey berhasil dikirim", Toast.LENGTH_SHORT).show()
                            navController.navigate("home") // Navigasi ke halaman home
                        },
                        onError = { error ->
                            // Tampilkan Toast error
                            Toast.makeText(context, "Error: $error", Toast.LENGTH_SHORT).show()
                        }
                    )
                },
                onClickBack = { navController.navigate("expense_survey") }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Survey",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Akses Layanan",
                fontSize = 20.sp,
                style = MaterialTheme.typography.titleMedium
            )

            // Checkbox List
            CheckboxWithLabel(
                label = "Akses terhadap layanan keuangan.",
                isChecked = aksesKeuangan,
                onCheckedChange = {
                    aksesKeuangan = it
                    viewModel.financialServiceAccess = it
                }
            )

            CheckboxWithLabel(
                label = "Akses ke layanan kesehatan.",
                isChecked = aksesKesehatan,
                onCheckedChange = {
                    aksesKesehatan = it
                    viewModel.healthServiceAccess = it
                }
            )

            CheckboxWithLabel(
                label = "Partisipasi dalam program bantuan pemerintah.",
                isChecked = bantuanPemerintah,
                onCheckedChange = {
                    bantuanPemerintah = it
                    viewModel.governmentAssistance = it
                }
            )

        }
    }
}
