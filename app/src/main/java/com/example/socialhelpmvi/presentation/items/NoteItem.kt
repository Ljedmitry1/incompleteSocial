package com.example.socialhelpmvi.presentation.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialhelpmvi.domain.model.ProblemModel
import com.example.socialhelpmvi.presentation.theme.Green
import com.example.socialhelpmvi.presentation.theme.GreenGray
import com.example.socialhelpmvi.presentation.theme.fonts

@Composable
fun NoteItem(note: ProblemModel, modifier: Modifier) {

    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(GreenGray)
                .padding(vertical = 16.dp, horizontal = 24.dp)
        ) {
            Column {
                Text(
                    text = note.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = fonts,
                    color = Green
                )

                Text(
                    text = note.desc,
                    fontSize = 20.sp,
                    fontFamily = fonts,
                    color = Green
                )

                Text(
                    text = note.complex,
                    fontSize = 15.sp,
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    color = Green
                )
            }
        }
    }

}