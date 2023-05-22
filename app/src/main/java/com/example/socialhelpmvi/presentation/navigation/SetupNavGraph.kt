package com.example.socialhelpmvi.presentation.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.socialhelpmvi.presentation.screens.login.LoginScreen
import com.example.socialhelpmvi.presentation.screens.main.MainScreen
import com.example.socialhelpmvi.presentation.screens.registration.RegistrationScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

sealed class Screen(val route: String){
    object LoginScreen: Screen("login_screen")
    object RegistrationScreen: Screen("reg_screen")
    object MainScreen: Screen("main_screen")
}

@Composable
fun SetupNavGraph(navController: NavHostController, ref: DatabaseReference, auth: FirebaseAuth, context: Activity) {
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route){
        composable(Screen.LoginScreen.route){
            LoginScreen(navController, auth, context)
        }
        composable(Screen.RegistrationScreen.route){
            RegistrationScreen(navController, ref, auth, context)
        }

        composable(Screen.MainScreen.route){
            MainScreen(navController)
        }
    }
}