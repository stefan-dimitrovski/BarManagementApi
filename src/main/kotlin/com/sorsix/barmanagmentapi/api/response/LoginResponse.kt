package com.sorsix.barmanagmentapi.api.response

import com.sorsix.barmanagmentapi.domain.Locale
import com.sorsix.barmanagmentapi.domain.enumerations.Role

data class LoginResponse(
    val token: String,
    val id: Long,
    val email: String,
    val name: String,
    val role: Role,
    val locale: Locale?
)