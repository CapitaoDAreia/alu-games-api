package domain.entities

data class SeparatePlan(
    val type: String
){
    fun calculateValue(rent: Rent): Double {
        return rent.game.price * rent.period.periodInDays
    }
}
