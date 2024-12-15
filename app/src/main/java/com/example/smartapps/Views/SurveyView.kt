//package com.example.smartapps.Views
//
//import androidx.lifecycle.ViewModel
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.viewModelScope
//import com.example.smartapps.Models.Survey
//import com.example.smartapps.networks.ApiClient
//import kotlinx.coroutines.launch
//
//class SurveyViewModel(private val userViewModel: UserViewModel) : ViewModel() {
//    var user by mutableStateOf("")
//    var name by mutableStateOf("")
//    var job by mutableStateOf("")
//    var income by mutableStateOf("")
//    var foodExpense by mutableStateOf("")
//    var educationExpense by mutableStateOf("")
//    var healthExpense by mutableStateOf("")
//    var transportationTaxExpense by mutableStateOf("")
//    var pbbTaxExpense by mutableStateOf("")
//    var electricityExpense by mutableStateOf("")
//    var financialServiceAccess by mutableStateOf(false)
//    var healthServiceAccess by mutableStateOf(false)
//    var governmentAssistance by mutableStateOf(false)
//
//    fun getSurveyData(): Survey {
//        return Survey(
//            user = user,
//            name = name,
//            job = job,
//            income = income,
//            foodExpense = foodExpense,
//            educationExpense = educationExpense,
//            healthExpense = healthExpense,
//            transportationTaxExpense = transportationTaxExpense,
//            pbbTaxExpense = pbbTaxExpense,
//            electricityExpense = electricityExpense,
//            financialServiceAccess = financialServiceAccess,
//            healthServiceAccess = healthServiceAccess,
//            governmentAssistance = governmentAssistance
//        )
//    }
//}
