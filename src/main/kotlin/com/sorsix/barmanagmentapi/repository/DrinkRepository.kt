package com.sorsix.barmanagmentapi.repository

import com.sorsix.barmanagmentapi.domain.Drink
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DrinkRepository : JpaRepository<Drink, Long> {

}
