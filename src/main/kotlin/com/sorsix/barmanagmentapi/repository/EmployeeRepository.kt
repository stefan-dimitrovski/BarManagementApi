package com.sorsix.barmanagmentapi.repository

import com.sorsix.barmanagmentapi.domain.Locale
import com.sorsix.barmanagmentapi.domain.User
import com.sorsix.barmanagmentapi.domain.enumerations.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : JpaRepository<User, Long> {

    fun findByRole(role: Role = Role.WAITER): List<User>

    @Query("SELECT e FROM User e WHERE lower(e.name) LIKE %:name%")
    fun findByName(name: String): List<User>

    @Modifying
    @Query("UPDATE User e SET e.worksInLocale = :localeId WHERE e.id = :userId")
    fun updateWorksInLocale(userId: Long, localeId: Locale)

    fun findByWorksInLocale(locale: Locale): List<User>
}
