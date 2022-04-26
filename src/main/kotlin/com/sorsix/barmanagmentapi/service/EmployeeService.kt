package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.domain.User
import com.sorsix.barmanagmentapi.repository.EmployeeRepository
import com.sorsix.barmanagmentapi.repository.LocaleRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository,
    private val localeRepository: LocaleRepository
) {
    private val logger = LoggerFactory.getLogger(EmployeeService::class.java)

    fun getAllEmployees(): List<User> =
        this.employeeRepository.findByRole()

    fun findEmployeesByName(name: String): List<User> =
        this.employeeRepository.findByName(name.lowercase())

    @Transactional
    fun addEmployeeToLocale(employeeId: Long, localeId: Long): Boolean {
        val employee = this.employeeRepository.findById(employeeId)
        val locale = this.localeRepository.findById(localeId)

        return if (!employee.isPresent && locale.isPresent) {
            false
        } else {
            logger.info("Updating user with id: [{}] works in locale with id: [{}] ", employeeId, localeId)

            this.employeeRepository.updateWorksInLocale(
                userId = employeeId,
                localeId = locale.get()
            )
            true
        }
    }
}
