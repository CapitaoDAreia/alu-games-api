package domain.entities

class SubscriptionPlan(type: String, val monthlyPayment: Double, val includedGames: Int) : Plan(type) {
    override fun calculateValue(rent: Rent): Double {
        val totalGamesInAMonth = rent.gamer.gamesInAMonth(rent.period.initialDate.monthValue).size + 1

        return if (totalGamesInAMonth <= includedGames) {
            0.0
        } else {
            super.calculateValue(rent)
        }
    }
}