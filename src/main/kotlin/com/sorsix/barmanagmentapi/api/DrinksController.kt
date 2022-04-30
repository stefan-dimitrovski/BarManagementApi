package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.domain.Drink
import com.sorsix.barmanagmentapi.service.DrinkService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/drinks")
@CrossOrigin
class DrinksController(val drinkService: DrinkService) {

    @GetMapping
    fun getDrinks(): List<Drink> = drinkService.getAllDrinks()


    @GetMapping
    fun getDrinksByName(@RequestParam q: String?): List<Drink> =
        q?.let {
            this.drinkService.findDrinksByName(q)
        } ?: run {
            this.drinkService.getAllDrinks()
        }
}
