package com.sorsix.barmanagmentapi.dto

data class DrinksInOrderDTO(
    val drinkId: Long,
    val orderId: Long,
    val quantity: Int
)