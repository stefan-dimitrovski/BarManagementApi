package com.sorsix.barmanagmentapi.domain.views

import net.jcip.annotations.Immutable
import org.hibernate.annotations.Subselect
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@Immutable
@Subselect(
    value = "SELECT * FROM order_view"
)
data class OrderView(
    @Id
    @Column(name = "order_id")
    val orderId: Long,
    @Column(name = "opened_at")
    val openedAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "closed_at")
    val closedAt: LocalDateTime?,
    @Column(name = "table_id")
    val tableId: Long,
    @Column(name = "waiter_name")
    val waiterName: String,
    @Column(name = "drink_name")
    val drinkName: String,
    @Column(name = "drink_category")
    val drinkCategory: String,
    @Column(name = "drink_price")
    val drinkPrice: Double,
    @Column(name = "quantity")
    val quantity: Int
)