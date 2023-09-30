package domain.entities

import java.time.Period

data class Rent(
    val gamer: Gamer,
    val game: Game,
    val period: domain.entities.Period
){
    private val rentValue = game.price * period.periodInDays

    override fun toString(): String {
        return "${gamer.name} has rent ${game.title} for price: ${this.rentValue}"
    }
}
