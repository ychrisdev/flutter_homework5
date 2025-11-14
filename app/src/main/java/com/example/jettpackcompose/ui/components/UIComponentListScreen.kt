package com.example.jettpackcompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jettpackcompose.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UIComponentListScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "UI Components List",
                        color = Color(0xFF1976D2),
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Section("Display")
            ComponentItem("Text", "Displays text") {
                navController.navigate(Routes.TEXT)
            }
            ComponentItem("Image", "Displays an image") {
                navController.navigate(Routes.IMAGE)
            }

            Section("Input")
            ComponentItem("TextField", "Input field for text") {
                navController.navigate(Routes.TEXTFIELD)
            }
            ComponentItem("PasswordField", "Input field for passwords")

            Section("Layout")
            ComponentItem("Column", "Arranges elements vertically") {
                navController.navigate(Routes.COLUMN)
            }
            ComponentItem("Row", "Arranges elements horizontally") {
                navController.navigate(Routes.ROW)
            }

            Spacer(modifier = Modifier.height(12.dp))
            ComponentItem(
                title = "Tự tìm hiểu",
                description = "Tìm ra tất cả các thành phần UI cơ bản",
                backgroundColor = Color(0xFFFFCDD2)
            )
        }
    }
}

@Composable
private fun Section(title: String) {
    Text(
        text = title,
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
private fun ComponentItem(
    title: String,
    description: String,
    backgroundColor: Color = Color(0xFFE3F2FD),
    onClick: (() -> Unit)? = null
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = backgroundColor,
        shadowElevation = 3.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .let {
                if (onClick != null) it.clickable(onClick = onClick) else it
            }
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = title, fontWeight = FontWeight.Bold, color = Color(0xFF0D47A1))
            Text(text = description, color = Color.DarkGray)
        }
    }
}
