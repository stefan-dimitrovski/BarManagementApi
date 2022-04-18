package com.sorsix.barmanagmentapi.domain

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table
import com.sorsix.barmanagmentapi.domain.Table as TableDomain

@Entity
@Table(name = "orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0L,
    @Column(name = "opened_at")
    val openedAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "closed_at")
    var closedAt: LocalDateTime? = null,
    @Column(name = "total_price")
    val totalPrice: Double = 0.0,
    @OneToOne(fetch = FetchType.EAGER)
    val table: TableDomain,
    @ManyToOne(fetch = FetchType.EAGER)
    val waiter: User

)
