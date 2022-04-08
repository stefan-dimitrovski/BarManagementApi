package com.sorsix.barmanagmentapi.api.response

import com.sorsix.barmanagmentapi.domain.User

sealed interface AccountResponse

//data class RegisterMessage(val message: String) : AccountResponse
data class RegisterSuccess(val user: User) : AccountResponse
//data class RegisterError(val message: String) : AccountResponse
