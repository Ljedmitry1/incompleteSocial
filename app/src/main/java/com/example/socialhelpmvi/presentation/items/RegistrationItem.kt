package com.example.socialhelpmvi.presentation.items

import android.app.Activity
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.socialhelpmvi.presentation.navigation.Screen
import com.example.socialhelpmvi.presentation.theme.Green
import com.example.socialhelpmvi.presentation.theme.GreenGray
import com.example.socialhelpmvi.presentation.theme.fonts
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationItem(navController: NavController, modifier: Modifier, ref: DatabaseReference, auth: FirebaseAuth, context: Activity) {
    var login by remember {
        mutableStateOf("")
    }

    var email by remember() {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = login,
                onValueChange = { login = it },
                colors = TextFieldDefaults.textFieldColors(
                    GreenGray,
                    focusedIndicatorColor = GreenGray,
                    containerColor = Color.Transparent
                )
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                colors = TextFieldDefaults.textFieldColors(
                    GreenGray,
                    focusedIndicatorColor = GreenGray,
                    containerColor = Color.Transparent
                )
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                colors = TextFieldDefaults.textFieldColors(
                    GreenGray,
                    focusedIndicatorColor = GreenGray,
                    containerColor = Color.Transparent
                ),
                visualTransformation = PasswordVisualTransformation()
            )

            Button(onClick = {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(context) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            navController.navigate(Screen.MainScreen.route) {
                                popUpTo(Screen.MainScreen.route) {
                                    inclusive = true
                                }
                            }
                            val user = auth.currentUser

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        }
                    }
            }, colors = ButtonDefaults.buttonColors(GreenGray), modifier = Modifier.width(320.dp)) {
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