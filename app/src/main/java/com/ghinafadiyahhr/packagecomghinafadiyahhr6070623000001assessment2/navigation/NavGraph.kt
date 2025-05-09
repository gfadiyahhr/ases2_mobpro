package com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.screen.DetailScreen
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.screen.MainScreen
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.screen.KEY_ID_BELANJA

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route // Set initial screen route
    ) {
        // Define the main screen (home)
        composable(route = Screen.Home.route) {
            MainScreen(navController)  // Pass the navController to navigate between screens
        }

        // Define screen for adding a new item (FormBaru)
        composable(route = Screen.FormBaru.route) {
            DetailScreen(navController)  // Pass navController to DetailScreen
        }

        // Define screen for updating an item (FormUbah), expecting an id argument
        composable(
            route = Screen.FormUbah.route,
            arguments = listOf(
                navArgument(KEY_ID_BELANJA) { type = NavType.LongType } // Expect a Long argument
            )
        ) { navBackStackEntry ->
            // Retrieve the id argument from the back stack
            val id = navBackStackEntry.arguments?.getLong(KEY_ID_BELANJA)
            // Pass the id to the DetailScreen
            DetailScreen(navController, id)
        }
    }
}
