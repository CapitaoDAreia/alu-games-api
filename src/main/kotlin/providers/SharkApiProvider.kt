package providers

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun getGame(uri: String): HttpResponse<String> {
    val client: HttpClient = HttpClient.newHttpClient()

    val request: HttpRequest = HttpRequest
        .newBuilder()
        .uri(URI.create(uri))
        .build()

    return client.send(request, HttpResponse.BodyHandlers.ofString())
}