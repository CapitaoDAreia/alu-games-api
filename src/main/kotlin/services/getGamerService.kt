package services

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import domain.dto.apiShark.InfoGamerDTO
import domain.entities.Gamer
import providers.sharkApiProvider
import java.net.http.HttpResponse

fun getGamerService(): List<Gamer> {
    val response: HttpResponse<String> =
        sharkApiProvider("https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json")

    if (response.statusCode() == 404) {
        println("Gamer not found!")
    }

    val gson = Gson()
    val listGamersType = object : TypeToken<List<InfoGamerDTO>>() {}.type
    val listGamersJson: List<InfoGamerDTO> =
        gson.fromJson(response.body(), listGamersType) ?: throw Exception("info gamer is null")

    return listGamersJson.map { infoGamerDTO -> infoGamerDTO.createGamer() }
}