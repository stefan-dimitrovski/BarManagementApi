package com.sorsix.barmanagmentapi.repository

import com.sorsix.barmanagmentapi.domain.views.OrderView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderViewRepository : JpaRepository<OrderView, Long> {

    fun findByOrderId(orderId : Long) : List<OrderView>?
}