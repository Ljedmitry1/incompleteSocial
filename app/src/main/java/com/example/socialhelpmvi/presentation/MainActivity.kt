package com.example.socialhelpmvi.presentation

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.content.getSystemService
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.socialhelpmvi.presentation.navigation.SetupNavGraph
import com.example.socialhelpmvi.presentation.screens.main.MainScreen
import com.example.socialhelpmvi.presentation.theme.SocialHelpMviTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Firebase.database.reference

        setContent {
            val navController = rememberNavController()
            SocialHelpMviTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SetupNavGraph(navController = navController, database, auth, this)
                }
            }
        }
    }

}

