package com.sorsix.barmanagmentapi.api.requests

data class UpdateDrinkInOrderRequest(
    val drinkInOrderId: Long,
    val quantity: Int
)