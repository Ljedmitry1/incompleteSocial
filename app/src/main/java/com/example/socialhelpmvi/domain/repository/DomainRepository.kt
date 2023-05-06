package com.example.socialhelpmvi.domain.repository

import com.example.socialhelpmvi.domain.model.ProblemModel

interface DomainRepository {

    suspend fun getAllProblems(): List<ProblemModel>

}