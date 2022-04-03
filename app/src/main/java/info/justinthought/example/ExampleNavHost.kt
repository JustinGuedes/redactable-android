package info.justinthought.example

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import info.justinthought.example.models.ExampleScreens
import info.justinthought.example.views.CustomLoadingView
import info.justinthought.example.views.DefaultView
import info.justinthought.example.views.HomeView

@Composable
fun ExampleNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ExampleScreens.HOME.name
    ) {
        composable(ExampleScreens.HOME.name) {
            HomeView(navController = navController)
        }

        composable(ExampleScreens.DEFAULT.name) {
            DefaultView(navController = navController)
        }

        composable(ExampleScreens.CUSTOM_LOADING.name) {
            CustomLoadingView(navController = navController)
        }
    }
}