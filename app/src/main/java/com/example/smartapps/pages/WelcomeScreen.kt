import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartapps.R
import com.example.smartapps.components.SubmitButton
import com.example.smartapps.ui.theme.PrimaryButtonColor
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(navController: NavController) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo SMART",
                modifier = Modifier.width(200.dp),
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Horizontal Pager for sliding text content
            HorizontalPager(
                count = 2,
                state = pagerState,
                modifier = Modifier.fillMaxWidth()
            ) { page ->
                when (page) {
                    0 -> {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Survey Kondisi Ekonomi",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "Temukan wawasan ekonomi Anda dan berpartisipasilah dalam survei nasional.",
                                fontSize = 16.sp,
                                color = Color.Gray,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )
                        }
                    }
                    1 -> {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Survey Kondisi Ekonomi",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "Dapatkan wawasan lebih dalam dan temukan cara untuk meningkatkan kondisi ekonomi Anda.",
                                fontSize = 16.sp,
                                color = Color.Gray,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Dot indicators
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                repeat(2) { index ->
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(
                                if (pagerState.currentPage == index) PrimaryButtonColor else Color.Gray,
                                shape = MaterialTheme.shapes.small
                            )
                    )
                    if (index < 1) Spacer(modifier = Modifier.width(4.dp))
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Log In Button
            SubmitButton(
                text = "Login",
                onClick = { navController.navigate("login") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Belum memiliki akun? Daftar di sini",
                fontSize = 14.sp,
                modifier = Modifier.clickable(onClick = { navController.navigate("register") })
            )
        }
    }
}
