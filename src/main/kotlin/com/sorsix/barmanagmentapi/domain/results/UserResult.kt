package com.sorsix.barmanagmentapi.domain.results

import com.sorsix.barmanagmentapi.domain.User

sealed interface UserResult

data class ResultSuccess(val user: User) : UserResult
object ResultError : UserResult