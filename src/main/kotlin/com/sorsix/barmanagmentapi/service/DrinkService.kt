package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.domain.Drink
import com.sorsix.barmanagmentapi.repository.DrinkRepository
import org.springframework.stereotype.Service

@Service
class DrinkService(private val drinkRepository: DrinkRepository) {

    fun findDrinksByName(name: String): List<Drink> =
        this.drinkRepository.findByName(name.lowercase())

    fun getAllDrinks(): List<Drink> =
        this.drinkRepository.findAll()
}
