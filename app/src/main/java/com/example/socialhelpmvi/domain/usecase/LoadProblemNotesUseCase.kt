package com.example.socialhelpmvi.domain.usecase

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.socialhelpmvi.data.DomainRepositoryImpl
import com.example.socialhelpmvi.domain.model.ProblemModel
import javax.inject.Inject

class LoadProblemNotesUseCase @Inject constructor(
    private val domainRepository: DomainRepositoryImpl
) : BaseUseCase<List<ProblemModel>>(){

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun invoke(): List<ProblemModel> = domainRepository.getAllProblems()

}