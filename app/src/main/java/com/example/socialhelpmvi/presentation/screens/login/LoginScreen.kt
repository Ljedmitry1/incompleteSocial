package com.example.socialhelpmvi.presentation.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.socialhelpmvi.presentation.items.LoginItem
import com.example.socialhelpmvi.presentation.theme.Green

@Composable
fun LoginScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize().background(Green)) {

        LoginItem(navController = navController, modifier = Modifier.fillMaxSize())
    }

}