package com.sorsix.barmanagmentapi.api.requests

data class DrinkInOrderRequest(
    val orderId: Long,
    val drinkId: Long,
    val quantity: Int
)