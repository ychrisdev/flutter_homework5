package com.example.jettpackcompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "TextField",
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
        // ✅ Căn giữa toàn bộ nội dung cả dọc và ngang
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var text by remember { mutableStateOf("") }

            // 📝 TextField có bo góc và border màu xanh
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Nhập nội dung tại đây") },
                singleLine = true,
                shape = RoundedCornerShape(12.dp), // ✅ Bo góc
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF1976D2),
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = Color(0xFF1976D2)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // 🔴 Text hiển thị bên dưới, màu đỏ khi chưa nhập
            Text(
                text = if (text.isEmpty()) "Tự động cập nhật dữ liệu theo textfield" else text,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (text.isEmpty()) Color.Red else Color(0xFF1E88E5)
            )
        }
    }
}
