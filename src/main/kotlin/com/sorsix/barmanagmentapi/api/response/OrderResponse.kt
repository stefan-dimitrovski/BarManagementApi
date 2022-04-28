package com.sorsix.barmanagmentapi.api.response

import com.sorsix.barmanagmentapi.domain.Order

sealed interface OrderResponse

data class OrderAlreadyExists(val message: String, val order: Order) : OrderResponse
data class OrderOk(val message: String, val order: Order) : OrderResponse
data class OrderError(val message: String) : DrinkInOrderResponse
