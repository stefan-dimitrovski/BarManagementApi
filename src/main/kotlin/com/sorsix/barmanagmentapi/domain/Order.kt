package com.sorsix.barmanagmentapi.domain

import java.time.LocalDateTime
import javax.persistence.*
import javax.persistence.Table
import com.sorsix.barmanagmentapi.domain.Table as TableDomain

@Entity
@Table(name = "orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "opened_at")
    val openedAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "closed_at")
    var closedAt: LocalDateTime? = null,
    @OneToOne(fetch = FetchType.EAGER)
    val table: TableDomain,
    @ManyToOne(fetch = FetchType.EAGER)
    val waiter: User
)