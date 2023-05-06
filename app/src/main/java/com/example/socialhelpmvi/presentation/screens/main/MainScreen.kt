package com.example.socialhelpmvi.presentation.screens.main

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.socialhelpmvi.domain.model.ProblemModel
import com.example.socialhelpmvi.presentation.items.InternetItem
import com.example.socialhelpmvi.presentation.items.NoteItem
import com.example.socialhelpmvi.presentation.theme.fonts

@Composable
fun MainScreen(navController: NavController) {
    val viewModel = hiltViewModel<MainViewModel>()

    val state by viewModel.state.collectAsState()

    when {
        state.data.isNotEmpty() -> {
            Log.d("checkData", "Data size: ${state.data.size}")
            MainScreenContent(state.data)
        }

        state.intError != null -> {
            Log.d("checkData", "Data size: ${state.intError}")
            InternetItem()
        }
    }
}


@Composable
fun MainScreenContent(data: List<ProblemModel>) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            item {
                Text(
                    text = "Социальная помощь",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = fonts,
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(top = 16.dp)
                )
            }
            items(data){ note->

                NoteItem(note, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))

            }
        }

    }

}