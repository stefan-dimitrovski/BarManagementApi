package com.sorsix.barmanagmentapi.api.response

import com.sorsix.barmanagmentapi.domain.User

data class LoginResponse(
    val token: String,
    val user: User
)