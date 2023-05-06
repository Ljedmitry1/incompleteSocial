package com.example.socialhelpmvi.presentation.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.socialhelpmvi.presentation.navigation.Screen
import com.example.socialhelpmvi.presentation.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginItem(navController: NavController, modifier: Modifier) {
    var email by remember() {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                colors = TextFieldDefaults.textFieldColors(GreenGray, focusedIndicatorColor = GreenGray, containerColor = Color.Transparent),
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                colors = TextFieldDefaults.textFieldColors(GreenGray, focusedIndicatorColor = GreenGray, containerColor = Color.Transparent)
            )
            Button(
                onClick = {
                    navController.navigate(Screen.MainScreen.route) {
                        popUpTo(Screen.MainScreen.route) {
                            inclusive = true
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(GreenGray),
                modifier = Modifier.width(220.dp)
            ) {
                Text(
                    text = "Войти",
                    color = Green,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Bold
                )
            }


            Button(
                onClick = {
                    navController.navigate(Screen.RegistrationScreen.route) {
                        popUpTo(Screen.RegistrationScreen.route) {
                            inclusive = true
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(GreenGray),
                modifier = Modifier.width(220.dp)
            ) {
                Text(
                    text = "Регистрация",
                    color = Green,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
