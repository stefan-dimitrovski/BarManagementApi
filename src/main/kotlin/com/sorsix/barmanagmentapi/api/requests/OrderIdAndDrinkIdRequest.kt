package com.sorsix.barmanagmentapi.api.requests

data class OrderIdAndDrinkIdRequest(
    val orderId: Long,
    val drinkId: Long,
    val quantity: Int
)
