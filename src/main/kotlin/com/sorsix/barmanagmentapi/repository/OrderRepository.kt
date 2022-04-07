package com.sorsix.barmanagmentapi.repository

import com.sorsix.barmanagmentapi.domain.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Long> {
}