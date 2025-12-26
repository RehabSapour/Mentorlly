package com.example.mentorly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.mentorly.Design.data.datastore.readOnBoardingState
import com.example.mentorly.Design.navigation.NavGraph
import com.example.mentorly.ui.theme.MentorlyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MentorlyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()
                    val context = LocalContext.current
                    val onboardingCompleted by readOnBoardingState(context).collectAsState(initial = null)

                    val startDestination =
                        when (onboardingCompleted) {

                            null -> {
                                LoadScreen()
                                ""
                            }
                            true -> {
                                "home"
                            }

                            false -> {
                                "onboarding"
                            }
                        }
                    NavGraph(
                        navController,
                        "Role",
                        innerPadding
                    )

                }
            }
        }
    }
}
@Composable
fun LoadScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
