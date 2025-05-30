package com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.screen.DetailScreen
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.screen.KEY_ID_BELANJA
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.screen.MainScreen

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            MainScreen(navController)
        }
        composable(route = Screen.FormBaru.route) {
            DetailScreen(navController)
        }
        composable(
            route = Screen.FormUbah.route,
            arguments = listOf(
                navArgument(KEY_ID_BELANJA) { type = NavType.LongType }
            )
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getLong(KEY_ID_BELANJA)
            DetailScreen(navController, id)
        }
    }
}
