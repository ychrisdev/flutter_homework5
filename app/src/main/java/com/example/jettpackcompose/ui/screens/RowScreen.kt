package com.example.jettpackcompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RowScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Row Layout",
                        color = Color(0xFF1976D2),
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(0xFF1976D2)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            repeat(4) { // ✅ 4 hàng
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF0F0F0), shape = RoundedCornerShape(16.dp))
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val boxModifier = Modifier
                        .weight(1f) // ✅ mỗi khối chiếm đều không gian
                        .aspectRatio(1.6f) // ✅ tỉ lệ cố định để đều nhau (rộng hơn cao)
                        .padding(horizontal = 6.dp) // khoảng cách nhỏ giữa các hình
                        .clip(RoundedCornerShape(10.dp))

                    Box(
                        modifier = boxModifier.background(Color(0xFFB3E5FC)) // nhạt
                    )
                    Box(
                        modifier = boxModifier.background(Color(0xFF0288D1)) // đậm
                    )
                    Box(
                        modifier = boxModifier.background(Color(0xFFB3E5FC)) // nhạt
                    )
                }
            }
        }
    }
}
