package com.sorsix.barmanagmentapi.dto

data class DrinksInOrderRequest(
    val drinkId: Long,
    val orderId: Long,
    val localeId: Long,
    val quantity: Int
)