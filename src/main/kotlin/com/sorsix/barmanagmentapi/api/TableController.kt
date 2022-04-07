package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.domain.Table
import com.sorsix.barmanagmentapi.service.TableService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("/api/tables")
class TableController(
    val tableService: TableService
) {

    @GetMapping
    fun getAllTables(): List<Table> = tableService.getTables()

    @GetMapping("/{id}")
    fun getTableById(@PathVariable id: Long): Table? = tableService.getTableById(id)

    @PutMapping("/open/{id}")
    fun openTable(@PathVariable id: Long) {
        tableService.updateIsOpen(id, true)
    }

    @PutMapping("/close/{id}")
    fun closeTable(@PathVariable id: Long) {
        tableService.updateIsOpen(id, false)
    }
}
