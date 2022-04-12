package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.config.PasswordEncoderConfig
import com.sorsix.barmanagmentapi.domain.User
import com.sorsix.barmanagmentapi.dto.RegisterDTO
import com.sorsix.barmanagmentapi.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoderConfig
) : UserDetailsService {
    private val logger = LoggerFactory.getLogger(UserService::class.java)

    override fun loadUserByUsername(username: String): User? =
        userRepository.findByEmail(username)

    fun save(userDto: RegisterDTO): User =
        userRepository.save(
            User(
                email = userDto.email,
                password = passwordEncoder.passwordEncoder().encode(userDto.password),
                name = userDto.name
            )
        )
}
