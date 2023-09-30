package domain.entities

class Game(
    var title: String,
    var thumb: String,
) {

    private var description = ""
    override fun toString(): String {
        return "Game: '$title', Cover: '$thumb', Title: '$description')"
    }

}