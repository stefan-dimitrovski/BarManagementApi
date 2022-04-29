package com.sorsix.barmanagmentapi.domain.views

import net.jcip.annotations.Immutable
import org.hibernate.annotations.Subselect
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id


@Entity
@Immutable
@Subselect(
    value = "SELECT * FROM total_price_view"
)
data class TotalPriceVIew(
    @Id @Column(name = "order_id")
    val orderId: Long,
    @Column(name = "total_price")
    val totalPrice: Double
)