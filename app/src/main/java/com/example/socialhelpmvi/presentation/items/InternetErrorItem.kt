package com.example.socialhelpmvi.presentation.items

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun InternetItem() {
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "Нет интеренет соединения")
    }
}