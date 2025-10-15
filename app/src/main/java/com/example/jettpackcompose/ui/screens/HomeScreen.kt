package com.example.jettpackcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jettpackcompose.R
import com.example.jettpackcompose.navigation.Routes

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        // 🧑‍💻 Góc phải: tên người dùng
        Column(
            modifier = Modifier
                .align(Alignment.TopEnd),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "Trần Trọng Phúc",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = "087205014900",
                fontSize = 13.sp
            )
        }

        // 🌟 Logo + text ở giữa
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo (không viền)
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Jetpack Compose Logo",
                modifier = Modifier
                    .size(150.dp)
                    .padding(bottom = 24.dp)
            )

            // Tiêu đề
            Text(
                text = "Jetpack Compose",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Mô tả
            Text(
                text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            )
        }

        // 🟦 Nút “I’m ready” dưới đáy
        Button(
            onClick = { navController.navigate(Routes.UILIST) },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1E88E5) // xanh dương
            ),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(
                text = "I’m ready",
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}
