package com.example.smartapps.pages

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
import com.example.smartapps.components.DropdownInputField
import com.example.smartapps.components.BottomNavigationBar
import com.example.smartapps.components.CheckboxWithLabel

@Composable
fun JobSurveyScreen(navController: NavController) {
    var selectedJob by remember { mutableStateOf("") }

    val jobOptions = listOf(
        "< Rp.2.000.000",
        "Rp.2.000.000 - Rp.3.000.000",
        "Rp.3.000.000 - Rp.5.000.000",
        "> Rp.5.000.000",
    )

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

            // Dropdown for Income
            DropdownInputField(
                label = "Select",
                selectedOption = selectedJob,
                options = jobOptions,
                onOptionSelected = { selectedJob = it }
            )

        }
    }
}

@Composable
fun IncomeSurveyScreen(navController: NavController) {
    var selectedIncome by remember { mutableStateOf("") }

    val incomeOptions = listOf(
        "< Rp.2.000.000",
        "Rp.2.000.000 - Rp.3.000.000",
        "Rp.3.000.000 - Rp.5.000.000",
        "> Rp.5.000.000",
    )

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

            // Dropdown for Income
            DropdownInputField(
                label = "Select",
                selectedOption = selectedIncome,
                options = incomeOptions,
                onOptionSelected = { selectedIncome = it }
            )

        }
    }
}

@Composable
fun ExpenseSurveyScreen(navController: NavController) {
    // State for all dropdown
    var selectedFood by remember { mutableStateOf("") }
    var selectedEducation by remember { mutableStateOf("") }
    var selectedHealth by remember { mutableStateOf("") }
    var selectedTransportationTax by remember { mutableStateOf("") }
    var selectedPBBTax by remember { mutableStateOf("") }
    var selectedElecttricity by remember { mutableStateOf("") }

    // List dropdown
    val expensesOptionsFood = listOf(
        "< Rp.2.000.000",
        "Rp.2.000.000 - Rp.3.000.000",
        "Rp.3.000.000 - Rp.5.000.000",
        "> Rp.5.000.000",
    )
    val expensesOptionsEducation = listOf(
        "< Rp.2.000.000",
        "Rp.2.000.000 - Rp.3.000.000",
        "Rp.3.000.000 - Rp.5.000.000",
        "> Rp.5.000.000",
    )
    val expensesOptionsHealth = listOf(
        "< Rp.2.000.000",
        "Rp.2.000.000 - Rp.3.000.000",
        "Rp.3.000.000 - Rp.5.000.000",
        "> Rp.5.000.000",
    )
    val optionsTransportationTax = listOf(
        "< Rp.250.000",
        "Rp.250.000 - Rp.500.000",
        "Rp.500.000 - Rp.1.000.000",
        "> Rp.1.000.000",
    )
    val optionsPBBTax = listOf(
        "< Rp.2.000.000",
        "Rp.2.000.000 - Rp.3.000.000",
        "Rp.3.000.000 - Rp.5.000.000",
        "> Rp.5.000.000",
    )
    val optionsElectricity = listOf(
        "< Rp.50.000",
        "Rp.50.000 - Rp.150.000",
        "Rp.150.000 - Rp.250.000",
        "> Rp.250.000",
    )

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

            // Dropdown for Food
            DropdownInputField(
                label = "Makanan",
                selectedOption = selectedFood,
                options = expensesOptionsFood,
                onOptionSelected = { selectedFood = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Dropdown for Education
            DropdownInputField(
                label = "Pendidikan",
                selectedOption = selectedEducation,
                options = expensesOptionsEducation,
                onOptionSelected = { selectedEducation = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Dropdown for Health
            DropdownInputField(
                label = "Kesehatan",
                selectedOption = selectedHealth,
                options = expensesOptionsHealth,
                onOptionSelected = { selectedHealth = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Dropdown for Transportation Tax
            DropdownInputField(
                label = "Pajak Transportasi",
                selectedOption = selectedTransportationTax,
                options = optionsTransportationTax,
                onOptionSelected = { selectedTransportationTax = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Dropdown for PBB Tax
            DropdownInputField(
                label = "Pajak PBB",
                selectedOption = selectedPBBTax,
                options = optionsPBBTax,
                onOptionSelected = { selectedPBBTax = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Dropdown for Electricity
            DropdownInputField(
                label = "Listrik per bulan",
                selectedOption = selectedElecttricity,
                options = optionsElectricity,
                onOptionSelected = { selectedElecttricity = it }
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ServiceAccessSurveyScreen(navController: NavController) {
    var aksesKeuangan by remember { mutableStateOf(false) }
    var aksesKesehatan by remember { mutableStateOf(false) }
    var bantuanPemerintah by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                onClick = { navController.navigate("home") },
                onClickBack = { navController.navigate("expense_survey") }
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
                text = "Akses Layanan",
                fontSize = 20.sp,
                style = MaterialTheme.typography.titleMedium
            )

            // Checkbox List
            CheckboxWithLabel(
                label = "Akses terhadap layanan keuangan.",
                isChecked = aksesKeuangan,
                onCheckedChange = { aksesKeuangan = it }
            )

            CheckboxWithLabel(
                label = "Akses ke layanan kesehatan.",
                isChecked = aksesKesehatan,
                onCheckedChange = { aksesKesehatan = it }
            )

            CheckboxWithLabel(
                label = "Partisipasi dalam program bantuan pemerintah.",
                isChecked = bantuanPemerintah,
                onCheckedChange = { bantuanPemerintah = it }
            )

        }
    }
}
