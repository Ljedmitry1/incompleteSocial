package com.example.socialhelpmvi.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.compose.runtime.sourceInformation
import com.example.socialhelpmvi.domain.model.ProblemModel
import com.example.socialhelpmvi.domain.repository.DomainRepository
import com.example.socialhelpmvi.presentation.MainActivity
import javax.inject.Inject

class DomainRepositoryImpl @Inject constructor() : DomainRepository {

    val connect: MainActivity
        get() {
            TODO()
        }

    override suspend fun getAllProblems(): List<ProblemModel> {
        val connectivityManager: ConnectivityManager =
            connect.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activateNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        //val isConnected: Boolean = activateNetwork?.isConnectedOrConnecting == true
        val isConnected = true
        val list: List<ProblemModel>

        if (isConnected) {
            list = listOf(
                ProblemModel(
                    "Продукты",
                    "Наши волонтеры донесут продукты прямо из магазина к вам на адрес",
                    "Нормально"
                ),
                ProblemModel(
                    "Вещи",
                    "А",
                    "Нормально"
                ),
                ProblemModel(
                    "Артем",
                    "Б",
                    "Трудно"
                ),
                ProblemModel(
                    "Камчатка",
                    "В",
                    "Легко"
                )
            )

        } else {
            list = emptyList()
            println(" Empty list ")
        }

        return list
    }

}