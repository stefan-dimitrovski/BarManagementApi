package com.sorsix.barmanagmentapi.repository

import com.sorsix.barmanagmentapi.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
