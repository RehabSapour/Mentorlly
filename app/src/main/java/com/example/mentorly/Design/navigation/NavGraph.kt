package com.example.mentorly.Design.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mentorly.Design.Role.MentorshipOnboardingScreen
import com.example.mentorly.Design.data.datastore.saveOnBoardingState
import com.example.mentorly.Design.home.HomeScreen
import com.example.mentorly.Design.onboarding.OnBoardingScreen
import com.example.mentorly.Design.onboarding.SplashScreen
import com.example.mentorly.MyApp
import com.example.mentorly.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
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
            val viewModel: ViewModel = viewModel()
//            val scope = context.applicationContext as MyApp
//            var saveOnBoarding by remember { mutableStateOf(false) }

            SplashScreen(
                Modifier.padding(innerPadding),
                onNextClick = {
                    navController.navigate("onboarding")
                },
                onSkipClick = {
                    navController.navigate("Role") {
                        popUpTo("splash") { inclusive = true }
                        launchSingleTop=true
                    }
                    viewModel.saveOnBoarding(context)


                }
            )
//

        }

        composable("onboarding") {
//            val context = LocalContext.current
//            val scope = context.applicationContext as MyApp

            OnBoardingScreen(
                onFinish = {
                    navController.navigate("Role") {
                        popUpTo("splash") { inclusive = true }
                        launchSingleTop = true
                    }
//                    scope.applicationScope.launch {
//                        saveOnBoardingState(context)
//                    }
                })
            }

        composable("home") {
            HomeScreen()
        }
        composable("Role") {
            MentorshipOnboardingScreen (
                selectRole={
                    navController.navigate("home")
                }
            )
        }







    }
}

