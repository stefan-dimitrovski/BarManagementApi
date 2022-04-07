package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.config.PasswordEncoderConfig
import com.sorsix.barmanagmentapi.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(
    val repository: UserRepository,
    val encoder: PasswordEncoderConfig
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        TODO("Not yet implemented")
    }
}
