package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.config.PasswordEncoderConfig
import com.sorsix.barmanagmentapi.domain.User
import com.sorsix.barmanagmentapi.dto.RegisterDTO
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    val userService: UserService,
    val passwordEncoder: PasswordEncoderConfig
) {

    fun getCurrentUserId(): String = SecurityContextHolder.getContext().authentication.principal.toString()


}