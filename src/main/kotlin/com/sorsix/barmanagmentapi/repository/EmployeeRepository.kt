package com.sorsix.barmanagmentapi.repository

import com.sorsix.barmanagmentapi.domain.User
import com.sorsix.barmanagmentapi.domain.enumerations.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : JpaRepository<User, Long> {

    fun findByRole(role: Role = Role.WAITER): List<User>

    @Query("SELECT e FROM User e WHERE lower(e.name) LIKE %:name%")
    fun findByName(name: String): List<User>
}
