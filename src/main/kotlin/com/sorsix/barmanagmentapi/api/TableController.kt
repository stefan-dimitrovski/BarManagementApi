package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.domain.Table
import com.sorsix.barmanagmentapi.service.TableService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/tables")
class TableController(
    val tableService: TableService
) {

    @GetMapping
    fun getAllTables(): List<Table> = tableService.getTables()

    @PutMapping("/{id}")
    fun openTable(@PathVariable id: Long) {
        tableService.updateIsOpen(id, true)
    }

    @PutMapping("/close/{id}")
    fun closeTable(@PathVariable id: Long) {
        tableService.updateIsOpen(id, false)
    }

}