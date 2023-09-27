package domain.entities

class Game(
    private var title: String,
    private var thumb: String,
) {

    private val description = ""
    override fun toString(): String {
        return "Game: '$title', Cover: '$thumb', Title: '$description')"
    }

}