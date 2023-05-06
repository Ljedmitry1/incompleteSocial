package com.example.socialhelpmvi.presentation.screens.main

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.socialhelpmvi.domain.usecase.LoadProblemNotesUseCase
import com.example.socialhelpmvi.presentation.screens.base.Reducer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainScreenReducer(
    initial: MainScreenState,
    val useCase: LoadProblemNotesUseCase,
    val viewModelScope: CoroutineScope
) : Reducer<MainScreenState, MainScreenEvent>(initial) {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun reduce(oldState: MainScreenState, event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.ShowData -> {
                viewModelScope.launch {
                    useCase.invoke().let { data ->

                        if(data.isNotEmpty()){
                            setState(oldState.copy(data = data))
                        }else{
                            setState(oldState.copy(intError = "пусто тут"))
                        }

                    }
                }
            }

            is MainScreenEvent.ShowInternetError -> {
                setState(oldState.copy(data = emptyList(), intError = "Нет интернет соединения"))
            }
        }
    }
}