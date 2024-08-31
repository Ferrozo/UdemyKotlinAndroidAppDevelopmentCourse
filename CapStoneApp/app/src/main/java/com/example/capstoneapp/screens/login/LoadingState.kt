package com.example.capstoneapp.screens.login

data class LoadingState(
    val status: Status,
    val message: String? =null
){
    companion object {
        val Success = LoadingState(Status.Success)
        val Idle = LoadingState(Status.Idle)
        val Failure = LoadingState(Status.Failure)
        val Running = LoadingState(Status.Running)
    }
    enum class Status {
        Success,
        Idle,
        Running,
        Failure
    }

}
