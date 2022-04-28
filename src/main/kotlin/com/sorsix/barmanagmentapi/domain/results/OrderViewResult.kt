package com.sorsix.barmanagmentapi.domain.results

import com.sorsix.barmanagmentapi.domain.views.OrderView

sealed interface OrderViewResult

data class OrderViewOk (val orderViewList: List<OrderView>, val totalSum: Double) : OrderViewResult
object OrderViewFailed : OrderViewResult