package com.sorsix.barmanagmentapi.domain.results

sealed interface DrinkInOrderResult

object DrinkInOrderSuccess : DrinkInOrderResult
object DrinkInOrderNotFound : DrinkInOrderResult
