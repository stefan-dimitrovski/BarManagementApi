package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.domain.User
import com.sorsix.barmanagmentapi.dto.EmployeeLocaleDTO
import com.sorsix.barmanagmentapi.service.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping
    fun getEmployees(@RequestParam name: String?): List<User> =
        name?.let {
            this.employeeService.findEmployeesByName(name)
        } ?: run {
            this.employeeService.getAllEmployees()
        }

    @PutMapping("/add-to-locale")
    fun addEmployeeToLocale(@RequestBody request: EmployeeLocaleDTO): ResponseEntity<Any> {
        val result = this.employeeService.addEmployeeToLocale(request.employeeId, request.localeId)
        return if (result) {
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.badRequest().build()
        }
    }
}
