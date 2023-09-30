package domain.entities

import java.time.LocalDate
import java.time.Period

data class Period(
    val initialDate: LocalDate,
    val finalDate: LocalDate,
){
    val periodInDays: Int = Period.between(initialDate, finalDate).days
}
