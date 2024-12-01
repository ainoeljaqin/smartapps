package com.example.smartapps.networks

import com.example.smartapps.Model.Survey
import com.example.smartapps.Model.TokenResponse
import com.example.smartapps.Model.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("auth/register/")
    fun register(@Body user: Map<String, String>): Call<ResponseBody>

    @POST("auth/token/")
    fun login(@Body credentials: Map<String, String>): Call<TokenResponse>

    @GET("auth/user/")
    fun getUser(@Header("Authorization") token: String): Call<User>

    @GET("auth/users/")
    fun getAllUsers(@Header("Authorization") token: String): Call<List<User>>

    @GET("survey/{user_id}/")
    fun getUserSurvey(@Path("user_id") userId: Int, @Header("Authorization") token: String): Call<Survey>
}
