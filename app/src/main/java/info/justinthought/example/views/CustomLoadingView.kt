package info.justinthought.example.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import info.justinthought.example.common.row.ExampleRowView
import info.justinthought.example.views.viewModel.ViewModel
import info.justinthought.redactable.LoadableView

@Composable
fun CustomLoadingView(navController: NavController) {
    val viewModel = remember { ViewModel() }
    val loadable = viewModel.loadable.collectAsState()

    SideEffect {
        viewModel.loadData()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Custom Loading")
                },
                navigationIcon = {
                    IconButton(onClick = navController::popBackStack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = viewModel::loadData) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "refresh"
                        )
                    }
                })
        }
    ) {
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                LoadableView(
                    loadable = loadable.value,
                    loading = {
                        CircularProgressIndicator()
                    }
                ) { rows ->
                    LazyColumn {
                        items(rows) {
                            ExampleRowView(data = it)

                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CustomLoadingViewPreview() {
    CustomLoadingView(navController = rememberNavController())
}