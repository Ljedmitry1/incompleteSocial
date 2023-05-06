package com.example.socialhelpmvi.presentation.screens.main

import com.example.socialhelpmvi.domain.model.ProblemModel
import com.example.socialhelpmvi.presentation.screens.base.UiEvent
import javax.annotation.concurrent.Immutable

@Immutable
sealed class MainScreenEvent: UiEvent {

    data class ShowInternetError(val errorMessage: String): MainScreenEvent()

    data class ShowData(val data: List<ProblemModel>): MainScreenEvent()

}