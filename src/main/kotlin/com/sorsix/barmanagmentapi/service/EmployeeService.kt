package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.domain.User
import com.sorsix.barmanagmentapi.repository.EmployeeRepository
import com.sorsix.barmanagmentapi.repository.LocaleRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository,
    private val localeRepository: LocaleRepository
) {

    fun getAllEmployees(): List<User> {
        return this.employeeRepository.findByRole()
    }

    @Transactional
    fun addEmployeeToLocale(employeeId: Long, localeId: Long): Boolean {
        val employee = this.employeeRepository.findById(employeeId).get()
        val locale = this.localeRepository.findById(localeId).get()

        employee.worksInLocale = locale

        this.employeeRepository.save(employee)
        return true
    }
}