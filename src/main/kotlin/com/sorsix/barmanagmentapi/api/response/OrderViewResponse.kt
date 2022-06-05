package com.sorsix.barmanagmentapi.api.response

import com.sorsix.barmanagmentapi.domain.views.OrderView

data class OrderViewResponse(
    val orderViewList: List<OrderView>,
    val totalPrice : Double
)
