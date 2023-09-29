package domain.entities

class Game(
    private var title: String,
    private var thumb: String,
) {

    private var description = ""
    override fun toString(): String {
        return "Game: '$title', Cover: '$thumb', Title: '$description')"
    }

}