package domain.entities

sealed class Plan(val type: String) {
    open fun calculateValue(rent: Rent): Double {
        return rent.game.price * rent.period.periodInDays
    }
}