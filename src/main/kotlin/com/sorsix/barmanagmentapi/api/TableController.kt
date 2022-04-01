package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.service.TableService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/api/tables")
class TableController(
    val tableService: TableService
) {

    @GetMapping
    fun getAllTables() {
        TODO()
    }
}