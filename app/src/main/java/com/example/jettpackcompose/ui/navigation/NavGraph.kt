package com.example.jettpackcompose.navigation

import com.example.jettpackcompose.screens.HomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jettpackcompose.ui.screens.*

object Routes {
    const val HOME = "home"
    const val UILIST = "uilist"
    const val TEXT = "text"
    const val IMAGE = "image"
    const val TEXTFIELD = "textfield"
    const val ROW = "row"
    const val COLUMN = "column"
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.HOME // ✅ mở trang chính khi khởi động
    ) {
        composable(Routes.HOME) { HomeScreen(navController) }
        composable(Routes.UILIST) { UIComponentListScreen(navController) }
        composable(Routes.TEXT) { TextScreen(navController) }
        composable(Routes.IMAGE) { ImageScreen(navController) }
        composable(Routes.TEXTFIELD) { TextFieldScreen(navController) }
        composable(Routes.ROW) { RowScreen(navController) }
        composable(Routes.COLUMN) { ColumnScreen(navController) }

    }
}
