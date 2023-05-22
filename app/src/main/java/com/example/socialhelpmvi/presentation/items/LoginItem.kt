package com.example.socialhelpmvi.presentation.items

import android.app.Activity
import android.content.ContentValues
import android.util.Log
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
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginItem(
    navController: NavController,
    modifier: Modifier,
    auth: FirebaseAuth,
    context: Activity
) {
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
                label = { Text(text = "Почта") },
                colors = TextFieldDefaults.textFieldColors(
                    GreenGray,
                    focusedIndicatorColor = GreenGray,
                    containerColor = Color.Transparent,
                    focusedLabelColor = GreenGray
                ),
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Пароль") },
                colors = TextFieldDefaults.textFieldColors(
                    GreenGray,
                    focusedIndicatorColor = GreenGray,
                    containerColor = Color.Transparent,
                    focusedLabelColor = GreenGray
                )
            )
            Button(
                onClick = {
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(context) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(ContentValues.TAG, "signIN:success")
                                val user = auth.currentUser

                                navController.navigate(Screen.MainScreen.route) {
                                    popUpTo(Screen.MainScreen.route) {
                                        inclusive = true
                                    }
                                }

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(
                                    ContentValues.TAG,
                                    "createUserWithEmail:failure",
                                    task.exception
                                )
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
