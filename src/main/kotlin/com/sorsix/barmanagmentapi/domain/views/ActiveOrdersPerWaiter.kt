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
    value = "SELECT * FROM active_orders_per_waiter"
)
data class ActiveOrdersPerWaiter(
    @Id
    @Column(name = "order_id")
    val orderId: Long,
    @Column(name = "opened_at")
    val openedAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "closed_at")
    val closedAt: LocalDateTime?,
    @Column(name = "table_id")
    val tableId: Long,
    @Column(name = "waiter_id")
    val waiterId: Long,
    @Column(name = "works_at")
    val worksAtLocaleId: Long

)