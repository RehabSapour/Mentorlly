package com.example.mentorly.Design.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mentorly.Design.data.datastore.saveOnBoardingState
import com.example.mentorly.Design.home.HomeScreen
import com.example.mentorly.Design.onboarding.OnBoardingScreen
import com.example.mentorly.Design.onboarding.SplashScreen
import kotlinx.coroutines.launch

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable("splash") {
            val context = LocalContext.current
            val scope = rememberCoroutineScope()

            SplashScreen(
                Modifier.padding(innerPadding),
                onNextClick = {
                    navController.navigate("onboarding")
                },
                onSkipClick = {
                    scope.launch {
                        saveOnBoardingState(context)
                        navController.navigate("home") {
                            popUpTo("splash") { inclusive = true }
                            launchSingleTop=true
                        }
                    }
                }
            )

        }
        composable("onboarding") {
            val context = LocalContext.current
            val scope = rememberCoroutineScope()

            OnBoardingScreen(
                onFinish = {
                    scope.launch {
                        saveOnBoardingState(context)
                        navController.navigate("home") {
                            popUpTo("splash") { inclusive = true }
                            launchSingleTop=true
                        }
                    }
                }
            )

//
        }

        composable("home") {
            HomeScreen()
        }

    }
}

