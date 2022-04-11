package com.sorsix.barmanagmentapi.dto

import javax.validation.constraints.Email
import javax.validation.constraints.Size

data class LoginDTO(
    @get: Size(min = 3, max = 50)
    @get:Email
    val email: String,

    @get: Size(min = 5)
    val password: String
)
