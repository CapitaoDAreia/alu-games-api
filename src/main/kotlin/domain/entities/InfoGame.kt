package domain.entities
import domain.dto.apiShark.InfoApiSharkDTO

class InfoGame(
    val info: InfoApiSharkDTO
) {
    override fun toString(): String {
        return info.toString()
    }
}