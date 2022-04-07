package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.domain.Drink
import com.sorsix.barmanagmentapi.service.DrinkService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/drinks")
class DrinksController(val drinkService: DrinkService) {

    @GetMapping
    fun getDrinks(): List<Drink> = drinkService.getAllDrinks()
}
