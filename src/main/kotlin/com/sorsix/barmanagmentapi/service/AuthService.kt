package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.config.PasswordEncoderConfig
import com.sorsix.barmanagmentapi.domain.User
import com.sorsix.barmanagmentapi.dto.RegisterDTO
import com.sorsix.barmanagmentapi.repository.AuthRepository
import org.slf4j.LoggerFactory
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class AuthService(
    private val authRepository: AuthRepository,
    private val passwordEncoder: PasswordEncoderConfig
) : UserDetailsService {

    private val logger = LoggerFactory.getLogger(AuthService::class.java)

    override fun loadUserByUsername(username: String): User? {
        logger.info("Search user by email: [{}]", username)

        return authRepository.findByEmail(username)
    }

    fun createUser(registerDTO: RegisterDTO): User? {

        return try {
            logger.info("Saving user [{}]", registerDTO)

            authRepository.save(
                User(
                    email = registerDTO.email,
                    password = passwordEncoder.passwordEncoder().encode(registerDTO.password),
                    name = registerDTO.name,
                    phoneNumber = registerDTO.phoneNumber,
                    dateEmployed = LocalDateTime.now(),
                )
            )
        } catch (ex: DataIntegrityViolationException) {
            null
        }
    }
}
