package com.sorsix.barmanagmentapi.api.response

data class LoginResponse(
    val token: String,
    val id: Long,
    val email: String,
    val name: String,
)