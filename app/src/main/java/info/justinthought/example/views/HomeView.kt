package info.justinthought.example.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import info.justinthought.example.common.buttons.ExampleButton
import info.justinthought.example.models.ExampleScreens

@Composable
fun HomeView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Example")
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                ExampleButton(title = "Default", icon = Icons.Default.Home) {
                    navController.navigate(ExampleScreens.DEFAULT.name)
                }

                ExampleButton(title = "Custom Loading", icon = Icons.Default.Refresh) {
                    navController.navigate(ExampleScreens.CUSTOM_LOADING.name)
                }
            }
        }
    }
}