import com.google.gson.Gson
import domain.entities.Game
import domain.entities.InfoGame
import providers.getGame
import java.util.Scanner
import kotlin.Exception

fun main() {

    val scanner = Scanner(System.`in`)
    println("Type an game ID")
    val id = scanner.nextLine()

    val response = getGame("https://www.cheapshark.com/api/1.0/games?id=$id")
    val gson = Gson()
    val infoGame = gson.fromJson(response.body(), InfoGame::class.java) ?: throw Exception("info game is null")

    val game = Game(infoGame.info.title, infoGame.info.thumb)
    println(game)
}