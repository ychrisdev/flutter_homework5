package com.example.jettpackcompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Text Detail",
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
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .align(Alignment.TopCenter)
                    .padding(top = 120.dp),
                horizontalAlignment = Alignment.Start
            ) {
                val styled = buildAnnotatedString {
                    withStyle(SpanStyle(fontSize = 22.sp)) { append("The ") }
                    withStyle(SpanStyle(textDecoration = TextDecoration.LineThrough)) { append("quick ") }
                    withStyle(
                        SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFB87333),
                            fontSize = 40.sp
                        )
                    ) { append("Brown") }

                    append("\n")

                    withStyle(SpanStyle(fontSize = 22.sp)) { append("fox ") }
                    withStyle(SpanStyle(letterSpacing = 8.sp, fontSize = 22.sp)) { append("j u m p s ") }
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)) { append("over") }

                    append("\n")

                    withStyle(SpanStyle(textDecoration = TextDecoration.Underline, fontSize = 22.sp)) { append("the ") }
                    withStyle(SpanStyle(fontStyle = FontStyle.Italic, fontSize = 22.sp)) { append("lazy ") }
                    withStyle(SpanStyle(fontSize = 22.sp)) { append("dog.") }
                }

                Text(
                    text = styled,
                    lineHeight = 44.sp,
                    color = Color.Black
                )

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp),
                    color = Color(0xFFBDBDBD),
                    thickness = 1.dp
                )
            }
        }
    }
}
