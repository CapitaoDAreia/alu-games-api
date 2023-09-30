package domain.entities

class Game(
    var title: String,
    var thumb: String,
) {

    var price = 0
    private set

    private var description = ""
    override fun toString(): String {
        return "Game: '$title', Cover: '$thumb', Title: '$description')"
    }

}