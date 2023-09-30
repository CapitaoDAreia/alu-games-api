package utils

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.extractAgeFromBirthDate(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val birthDate = LocalDate.parse(this, formatter)
    val today = LocalDate.now()

    return Period.between(birthDate, today).years
}