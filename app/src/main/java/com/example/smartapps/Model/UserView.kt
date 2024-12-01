package com.example.smartapps.Model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.smartapps.networks.ApiClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {

    var user: User? = null
    var token: String? = null
    var userRole: String? = null

    fun register(username: String, email: String, password: String, role: String, onRegisterSuccess: (String) -> Unit) {
        val userMap = mapOf("username" to username, "email" to email, "password" to password, "role" to role)

        ApiClient.apiService.register(userMap).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    // Registrasi berhasil
                    onRegisterSuccess("Registration successful")
                } else {
                    // Jika terjadi error saat registrasi
                    println("Error: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                println("Error: ${t.message}")
            }
        })
    }

    // Fungsi login
    fun login(username: String, password: String, onSuccess: (String) -> Unit, onError: (String) -> Unit) {
        val credentials = mapOf("username" to username, "password" to password)

        ApiClient.apiService.login(credentials).enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                if (response.isSuccessful) {
                    token = response.body()?.access
                    onSuccess(response.body()?.access ?: "")
                } else {
                    onError("Login failed: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                onError("Error: ${t.message}")
            }
        })
    }

    // Fungsi untuk mengambil data user setelah login
    fun fetchUser(onSuccess: (User) -> Unit, onError: (String) -> Unit) {
        token?.let {
            ApiClient.apiService.getUser("Bearer $it").enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        user = response.body()
                        userRole = user?.role  // Set user role
                        user?.let { onSuccess(it) }
                    } else {
                        onError("Failed to fetch user: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    onError("Error: ${t.message}")
                }
            })
        } ?: onError("Token is null")
    }

    var users by mutableStateOf<List<User>>(emptyList())
    var errorMessage by mutableStateOf<String?>(null)

    fun fetchAllUsers(onSuccess: (List<User>) -> Unit, onError: (String) -> Unit) {
        val token = this.token  // Mengambil token yang disimpan dalam ViewModel
        if (token.isNullOrEmpty()) {
            onError("Token is missing or expired")
            return
        }

        ApiClient.apiService.getAllUsers("Bearer $token").enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        users = it
                        onSuccess(it)
                    }
                } else {
                    onError("Failed to fetch users: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                onError("Error: ${t.message}")
            }
        })
    }

    fun fetchUserSurvey(userId: Int, onSuccess: (Survey) -> Unit, onError: (String) -> Unit) {
        val token = this.token  // Mengambil token dari ViewModel
        if (token.isNullOrEmpty()) {
            onError("Token is missing or expired")
            return
        }

        ApiClient.apiService.getUserSurvey(userId, "Bearer $token").enqueue(object : Callback<Survey> {
            override fun onResponse(call: Call<Survey>, response: Response<Survey>) {
                if (response.isSuccessful) {
                    response.body()?.let { onSuccess(it) }
                } else {
                    onError("Failed to fetch survey data")
                }
            }

            override fun onFailure(call: Call<Survey>, t: Throwable) {
                onError("Error: ${t.message}")
            }
        })
    }

//    fun postSurvey(survey: Survey, onSuccess: (String) -> Unit, onError: (String) -> Unit) {
//        val token = this.token  // Mengambil token dari ViewModel
//        if (token.isNullOrEmpty()) {
//            onError("Token is missing or expired")
//            return
//        }
//
//        ApiClient.apiService.postSurvey("Bearer $token", survey).enqueue(object : Callback<ResponseBody> {
//            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//                if (response.isSuccessful) {
//                    onSuccess("Survey data successfully submitted")
//                } else {
//                    onError("Failed to submit survey data: ${response.message()}")
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                onError("Error: ${t.message}")
//            }
//        })
//    }

}

