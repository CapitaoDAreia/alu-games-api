import services.getGameService
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("Type an game ID")
    val id = scanner.nextLine()

    val game = getGameService(id)

    println(game)
}