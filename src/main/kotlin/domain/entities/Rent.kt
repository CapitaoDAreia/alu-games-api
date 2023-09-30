package domain.entities

import java.time.LocalDate
import java.time.Period

data class Rent(
    val gamer: Gamer,
    val game: Game,
    val initialDate: LocalDate,
    val finalDate: LocalDate
){
    private val rentValue = game.price * Period.between(initialDate, finalDate).days


    override fun toString(): String {
        return "${gamer.name} has rent ${game.title} for price: ${this.rentValue}"
    }
}
