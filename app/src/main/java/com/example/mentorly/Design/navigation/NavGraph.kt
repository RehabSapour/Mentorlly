package com.example.mentorly.Design.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

            SplashScreen(
                Modifier.padding(innerPadding),
                onNextClick = {
                    navController.navigate("onboarding")
                }
            )

        }
        composable("onboarding") {
            val context = LocalContext.current

            var navigateToHome by remember { mutableStateOf(false) }


            if (navigateToHome) {
                navController.navigate("home") {
                    popUpTo("onboarding") { inclusive = true }
                }
            }

            OnBoardingScreen(
                onFinish = {

                    navigateToHome = true
                }
            )


            LaunchedEffect(navigateToHome) {
                if (navigateToHome) {
                    saveOnBoardingState(context)
                }

            }
        }

        composable("home") {
            HomeScreen()
        }

    }
}

