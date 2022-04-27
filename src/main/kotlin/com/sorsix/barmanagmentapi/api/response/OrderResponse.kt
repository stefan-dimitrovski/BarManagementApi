package com.sorsix.barmanagmentapi.api.response

import com.sorsix.barmanagmentapi.domain.DrinkInOrder
import com.sorsix.barmanagmentapi.domain.Order

sealed interface OrderResponse

data class OrderAlreadyExists(val message: String, val order: Order) : OrderResponse
data class OrderOk(val message: String, val order: Order) : OrderResponse

data class DrinkInOrderOk(val drinkInOrder: DrinkInOrder) : OrderResponse
data class DrinkInOrderAlreadyExists(val message: String, val drinkInOrder: DrinkInOrder) : OrderResponse
data class OrderError(val message: String) : OrderResponse