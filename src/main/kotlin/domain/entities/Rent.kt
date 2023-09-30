package domain.entities

data class Rent(
    val gamer: Gamer,
    val game: Game
){
    override fun toString(): String {
        return "${gamer.name} has rent ${game.title}"
    }
}
