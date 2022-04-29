package com.sorsix.barmanagmentapi.repository

import com.sorsix.barmanagmentapi.domain.Locale
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocaleRepository : JpaRepository<Locale, Long> {

    fun getLocaleById(id: Long): Locale?

}
