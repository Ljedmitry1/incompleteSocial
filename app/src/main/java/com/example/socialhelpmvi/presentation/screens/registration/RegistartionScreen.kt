package com.example.socialhelpmvi.presentation.screens.registration

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.socialhelpmvi.presentation.items.RegistrationItem
import com.example.socialhelpmvi.presentation.theme.DarkGreen
import com.example.socialhelpmvi.presentation.theme.Green
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference


@Composable
fun RegistrationScreen(navController: NavController, ref: DatabaseReference, auth: FirebaseAuth, context: Activity) {

    Column(modifier = Modifier.background(Green)) {
        RegistrationItem(navController = navController, modifier = Modifier.fillMaxSize(), ref, auth, context)
    }


}