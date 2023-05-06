package com.example.socialhelpmvi.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.example.socialhelpmvi.domain.usecase.LoadProblemNotesUseCase
import com.example.socialhelpmvi.presentation.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(

    private val loadProblemNotesUseCase: LoadProblemNotesUseCase,

): BaseViewModel<MainScreenState, MainScreenEvent>(){
    private val reducer = MainScreenReducer(
        initial = MainScreenState.initial(),
        useCase = loadProblemNotesUseCase,
        viewModelScope = viewModelScope
    )

    override val state: StateFlow<MainScreenState>
        get() = reducer.state



    fun sendEvent(event: MainScreenEvent){
        reducer.sentEvent(event)
    }

}