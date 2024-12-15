package com.example.smartapps.pages.Admin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartapps.Models.Survey
import com.example.smartapps.Models.UserDetail
import com.example.smartapps.Views.UserViewModel
import com.example.smartapps.components.BackButton
import com.example.smartapps.components.admin.AksesLayananItem
import com.example.smartapps.components.admin.IncomeCard
import com.example.smartapps.components.admin.DetailSection


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailPage(
    userId: Int,
    navController: NavController,
    viewModel: UserViewModel
) {
    var survey by remember { mutableStateOf<Survey?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(userId) {
        viewModel.fetchUserSurvey(userId, onSuccess = {
            survey = it
        }, onError = {
            errorMessage = it
        })
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Detail Pengguna", color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF2196F3)
                )
            )
        },
        bottomBar = {
            BackButton(text = "Cancel", onClickBack = { navController.navigate("dasboard_admin") })
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Card(
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                Icons.Default.AccountCircle,
                                contentDescription = "User Icon",
                                tint = Color(0xFF2196F3),
                                modifier = Modifier.size(40.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                survey?.let {
                                    Text(
                                        text = it.name,
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF2196F3)
                                    )
                                    Text(
                                        text = it.job,
                                        fontSize = 16.sp,
                                        color = Color.Gray
                                    )
                                }
                            }
                        }
                    }
                }
            }

            item { survey?.let { IncomeCard(title = "Pendapatan", value = it.income) } }

            item {
                Card(
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Pengeluaran",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        survey?.let {
                            DetailSection(label = "Makanan", value = it.foodExpense)
                            DetailSection(label = "Pendidikan", value = it.educationExpense)
                            DetailSection(label = "Kesehatan", value = it.healthExpense)
                            DetailSection(label = "Pajak Transportasi", value = it.transportationTaxExpense)
                            DetailSection(label = "PBB", value = it.pbbTaxExpense)
                            DetailSection(label = "Listrik", value = it.electricityExpense)
                        }
                    }
                }
            }

            item {
                Card(
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Akses Layanan",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        survey?.let {
                            AksesLayananItem("Layanan Keuangan", it.financialServiceAccess)
                            AksesLayananItem("Layanan Kesehatan", it.healthServiceAccess)
                            AksesLayananItem("Bantuan Pemerintah", it.governmentAssistance)
                        }
                    }
                }
            }

            // Tingkat Ekonomi hasil klasifikasi
            item { survey?.let { IncomeCard(title = "Tingkat Ekonomi", value = it.economicLevel) } }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserDetailPage() {
    val navController = rememberNavController()
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
//    UserDetailPage(userDetail, navController)
}
