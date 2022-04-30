package com.sorsix.barmanagmentapi.repository

import com.sorsix.barmanagmentapi.domain.Drink
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface DrinkRepository : JpaRepository<Drink, Long> {

    @Query("SELECT d FROM Drink d WHERE lower(d.brandName) LIKE %:name%")
    fun findByName(name: String): List<Drink>

}
