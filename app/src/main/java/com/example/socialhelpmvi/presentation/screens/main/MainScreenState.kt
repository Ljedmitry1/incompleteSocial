package com.example.socialhelpmvi.presentation.screens.main

import com.example.socialhelpmvi.domain.model.ProblemModel
import com.example.socialhelpmvi.presentation.screens.base.UiState
import javax.annotation.concurrent.Immutable

@Immutable
data class MainScreenState(
    val intError: String? = null, // internet error
    val data: List<ProblemModel>
): UiState{
    companion object{
        fun initial() = MainScreenState(intError = null, data = emptyList())
    }
}