package com.example.socialhelpmvi.domain.usecase

abstract class BaseUseCase<T> {

    abstract suspend fun invoke(): T

}