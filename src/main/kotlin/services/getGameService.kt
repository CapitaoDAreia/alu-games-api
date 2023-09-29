package services

import com.google.gson.Gson
import domain.entities.Game
import domain.entities.InfoGame
import providers.sharkApiProvider
import java.net.http.HttpResponse

fun getGameService(id: String): Game {
    val response: HttpResponse<String> = sharkApiProvider("https://www.cheapshark.com/api/1.0/games?id=$id")

    if (response.statusCode() == 404){
        throw Exception("Game not found!")
    }

    val gson = Gson()
    val infoGame = gson.fromJson(response.body(), InfoGame::class.java) ?: throw Exception("info game is null")

    return Game(infoGame.info.title, infoGame.info.thumb)
}