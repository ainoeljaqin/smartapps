package com.example.smartapps.Views

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartapps.Models.Survey
import kotlinx.coroutines.launch
import com.example.smartapps.Models.User
import com.example.smartapps.networks.ApiClient

class UserViewModel : ViewModel() {

    var token: String? = null

    var users by mutableStateOf<List<User>>(emptyList())

    var user by mutableStateOf<User?>(null)
    var job by mutableStateOf("")
    var income by mutableStateOf("")
    var foodExpense by mutableStateOf("")
    var educationExpense by mutableStateOf("")
    var healthExpense by mutableStateOf("")
    var transportationTaxExpense by mutableStateOf("")
    var pbbTaxExpense by mutableStateOf("")
    var electricityExpense by mutableStateOf("")
    var financialServiceAccess by mutableStateOf(false)
    var healthServiceAccess by mutableStateOf(false)
    var governmentAssistance by mutableStateOf(false)
    var economicLevel by mutableStateOf("")

    // Register views
    fun register(username: String, email: String, password: String, onRegisterSuccess: (String) -> Unit) {
        val userMap = mapOf("username" to username, "email" to email, "password" to password)

        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.register(userMap)
                onRegisterSuccess("Registration successful")
            } catch (e: Exception) {
                // Tangani error seperti IOException atau HttpException
                println("Error: ${e.message}")
            }
        }
    }

    // Login views
    fun login(username: String, password: String, onSuccess: (String) -> Unit, onError: (String) -> Unit) {
        val credentials = mapOf("username" to username, "password" to password)

        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.login(credentials)
                token = response.access
                onSuccess(response.access ?: "")
            } catch (e: Exception) {
                onError("Login failed: ${e.message}")
            }
        }
    }

    // views to handle get user
    fun fetchUser(onSuccess: (User) -> Unit, onError: (String) -> Unit) {
        token?.let {
            viewModelScope.launch {
                try {
                    val Response = ApiClient.apiService.getUser("Bearer $it")
                    user = Response
                    onSuccess(Response)
                } catch (e: Exception) {
                    onError("Failed to fetch user: ${e.message}")
                }
            }
        } ?: onError("Token is null")
    }

    // view to handle get list user to display in admin page
    fun fetchAllUsers(onSuccess: (List<User>) -> Unit, onError: (String) -> Unit) {
        val token = this.token
        if (token.isNullOrEmpty()) {
            onError("Token is missing or expired")
            return
        }

        viewModelScope.launch {
            try {
                val userResponse = ApiClient.apiService.getAllUsers("Bearer $token")
                users = userResponse
                onSuccess(users)
            } catch (e: Exception) {
                onError("Error: ${e.message}")
            }
        }
    }

    // view to get survey data
    fun fetchUserSurvey(userId: Int, onSuccess: (Survey) -> Unit, onError: (String) -> Unit) {
        val token = this.token
        if (token.isNullOrEmpty()) {
            onError("Token is missing or expired")
            return
        }

        viewModelScope.launch {
            try {
                val survey = ApiClient.apiService.getUserSurvey(userId, "Bearer $token")
                onSuccess(survey)
            } catch (e: Exception) {
                onError("Error: ${e.message}")
            }
        }
    }

    fun getSurveyData(): Survey {
        return Survey(
            user = user?.id ?: throw IllegalStateException("User is null"),
            name = user?.username ?: throw IllegalStateException("Username is null"),
            job = job,
            income = income,
            foodExpense = foodExpense,
            educationExpense = educationExpense,
            healthExpense = healthExpense,
            transportationTaxExpense = transportationTaxExpense,
            pbbTaxExpense = pbbTaxExpense,
            electricityExpense = electricityExpense,
            financialServiceAccess = financialServiceAccess,
            healthServiceAccess = healthServiceAccess,
            governmentAssistance = governmentAssistance,
            economicLevel = economicLevel
        )
    }

    // view to handle post survey data
    fun postUserSurvey(survey: Survey, onSuccess: (Survey) -> Unit, onError: (String) -> Unit) {
        val token = this.token
        if (token.isNullOrEmpty()) {
            onError("Token is missing or expired")
            return
        }

        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.postSurvey("Bearer $token", survey)
                onSuccess(response)
            } catch (e: Exception) {
                onError("Error: ${e.localizedMessage}")
            }
        }
    }
}
