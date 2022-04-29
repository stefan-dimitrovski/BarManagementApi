package com.sorsix.barmanagmentapi.domain.results

import com.sorsix.barmanagmentapi.domain.DrinkInOrder

sealed interface DrinkInOrderResult

data class DrinkInOrderSuccess(val drinkInOrder: DrinkInOrder) : DrinkInOrderResult
object DrinkInOrderNotFound : DrinkInOrderResult
