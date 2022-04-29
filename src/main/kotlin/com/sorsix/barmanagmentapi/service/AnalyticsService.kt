package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.domain.results.EmployeesInLocalesAnalytics
import org.springframework.stereotype.Service
import java.text.DateFormatSymbols

@Service
class AnalyticsService(
    private val employeeService: EmployeeService,
    private val localeService: LocaleService,
) {

    fun getDrinksByPopularity(): List<Any> {
        return listOf()
    }

    fun getEmployeeNumbersByLocale(): MutableList<EmployeesInLocalesAnalytics> {
        val locales = localeService.getAllLocales()

        val result: MutableList<EmployeesInLocalesAnalytics> = mutableListOf()

        for (l in locales) {
            result.add(EmployeesInLocalesAnalytics(l, getEmployeesWorkingInLocale(l.id!!)))
        }

        return result
    }

    fun getEmployeesWorkingInLocale(locale: Long): MutableMap<String, Int> {
        val employees = employeeService.findEmployeesByLocale(locale)

        val monthsList: MutableList<String> = ArrayList()
        val months = DateFormatSymbols().months
        for (i in months.indices) {
            if (months[i] != "")
                monthsList.add(months[i].uppercase())
        }

        val employeesByMonth = employees.groupingBy {
            it.dateEmployed.month.toString()
        }.eachCount() as MutableMap<String, Int>

        val employeesByAllMonths = mutableMapOf<String, Int>()

        if (employees.isEmpty()) {
            for (month in monthsList) {
                employeesByAllMonths.putIfAbsent(month, 0)
            }
        } else {
            for (month in monthsList) {
                for (entry in employeesByMonth.entries) {
                    if (entry.key != month) {
                        employeesByAllMonths.putIfAbsent(month, 0)
                    } else {
                        employeesByAllMonths[entry.key] = entry.value
                        continue
                    }
                }
            }
        }

        return employeesByAllMonths
    }
}