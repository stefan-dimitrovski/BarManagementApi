package com.sorsix.barmanagmentapi.dto

import javax.validation.constraints.Email
import javax.validation.constraints.Size

data class RegisterDTO(
    @get: Size(min = 3, max = 50)
    @get:Email
    val email: String,

    @get:Size(min = 5, max = 100)
    val password: String,

    @get:Size(min = 4, max = 50)
    val name: String,
)
