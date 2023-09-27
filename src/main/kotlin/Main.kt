import com.google.gson.Gson
import domain.entities.Game
import domain.entities.InfoGame
import providers.getGame
import kotlin.Exception

fun main() {

    val response = getGame("https://www.cheapshark.com/api/1.0/games?id=146")

    val gson = Gson()

    val infoGame = gson.fromJson(response.body(), InfoGame::class.java) ?: throw Exception("info game is null")

    val game = Game(infoGame.info.title, infoGame.info.thumb)

    println(game)

}