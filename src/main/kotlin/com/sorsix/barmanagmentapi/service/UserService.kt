package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.domain.User
import com.sorsix.barmanagmentapi.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    fun saveUser(user: User): User =
        this.userRepository.save(user)

    fun findUserByEmail(email: String): User? =
        this.userRepository.findByEmail(email)
}
