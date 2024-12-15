import com.example.smartapps.Models.Survey
import com.example.smartapps.Models.TokenResponse
import com.example.smartapps.Models.User
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("auth/register/")
    suspend fun register(@Body user: Map<String, String>): ResponseBody

    @POST("auth/token/")
    suspend fun login(@Body credentials: Map<String, String>): TokenResponse

    @GET("auth/user/")
    suspend fun getUser(@Header("Authorization") token: String): User

    @GET("auth/users/")
    suspend fun getAllUsers(@Header("Authorization") token: String): List<User>

    @GET("survey/{user_id}/")
    suspend fun getUserSurvey(@Path("user_id") userId: Int, @Header("Authorization") token: String): Survey

    @POST("surveys/")
    suspend fun postSurvey(@Header("Authorization") token: String, @Body survey: Survey): Survey
}
