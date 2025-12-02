package com.example.microsaving

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.microsaving.state.SavingViewModel
import com.example.microsaving.ui.navigation.NavGraph
import com.example.microsaving.ui.theme.MicroSavingAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel: SavingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkMode by rememberSaveable { mutableStateOf(false) }
            val navController = rememberNavController()

            MicroSavingAppTheme(darkTheme = isDarkMode) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavGraph(
                        navController = navController,
                        viewModel = viewModel,
                        isDarkMode = isDarkMode,
                        onToggleDarkMode = { isDarkMode = !isDarkMode }
                    )
                }
            }
        }
    }
}
