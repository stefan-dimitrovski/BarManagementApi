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
    val id: Long,
    @Column(name = "opened_at")
    val openedAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "closed_at")
    val closedAt: LocalDateTime? = null,
//    @Column(name = "table_id")
    @OneToOne
    val tableId: TableDomain,
)